package com.leonardo.app.controller;


import com.leonardo.app.service.SopaService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController

public class SopaControlador {

    @Autowired
    private SopaService sopaServicio;
    
    
    @RequestMapping("/search-horandvert")
    // Se crea la funcion publica con a la cual le llega la solicitud ya en forma de OBJETO
    public ResponseEntity<Map<String, Object>> buscarPalabra(@RequestBody SopaSolicitud solicitud) {
        String searchword = solicitud.getSearchword(); // obtiene la frase para crear la sopa
        int rows = solicitud.getRows(); // obtiene la cantidad de filas a crear en la sopa
        String word = solicitud.getWord(); // obtiene la palabra a buscar

        // Aqui realizo una pequena validacion de los datos, (si entran campos vacios, nulos o filas menores a 1 no continua)
        boolean datosCorrectos = true; // inicializo la variable
        //condicional
        if (searchword == null || searchword.isEmpty()
                || rows < 1 || word == null || word.isEmpty()) {
            datosCorrectos = false;
        }
        // Estado Http que debolvera en caso de que alguna de las validaciones sea verdadera
        if (!datosCorrectos) {
            ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // Aqui creo la sopa letras
        char[][] sopa = sopaServicio.crearSopa(solicitud);
        

        // Buscar la palabra en la sopa de letras
        // aqui creo las variables con las que almacenare en caso de encontrar la palabra en que fila, columna inicia
        int startRow = -1;
        int startCol = -1;
        boolean contains = false; // esta variable almacenara la respuesta de la busqueda

        // con este bucle Busco  en horizontal en la sopa de caracteres 
        for (int indice = 0; indice < rows; indice++) {
            String palabraHorizontal = new String(sopa[indice]); // Esta variable almacenara la palabra
            if (palabraHorizontal.contains(word)) { //Verificara si la palabra buscada esta almacenada en palabra horizontal
                startRow = indice + 1; // aqui se ba sumando el indice buscado para encontrar en que fila inicia la palabra
                startCol = palabraHorizontal.indexOf(word) + 1; //con indexof busco de forma vertical la columna donde inicie la palabra 
                contains = true; // si encuentra la palabra devolvera este resultado
                break; // cuando encuentre la palabra finaliza la busqueda
            }
        }

        // aqui busco la palabra en vertical
        if (!contains) { // con la respuesta del anterior bucle verifico la condicion para buscar o no la palabra
            int colIndice = 0; // inicializo la posicion de la columna para buscar
            for (int indiceHorz = 0; indiceHorz < sopa[0].length; indiceHorz++) {
            	//en esta variable voy guardando los caractere encontrados y los casteo a un string con la funcion StringBuilder
            	// que me permite crear la palabra para compararla con la que se busca
                StringBuilder palabraVertical = new StringBuilder(); 
                //Con este ciclo mas interno busco letra por letra en forma vertical
                for (int indiceVert = 0; indiceVert < rows; indiceVert++) {
                	//Si encuentra el primer caracter lo agrega a palabraVertical que esta guardando los caracteres
                    palabraVertical.append(sopa[indiceVert][indiceHorz]);
                }
                //con este condicional verifico si la palabra vertical contiene la palabra buscada
                if (palabraVertical.toString().contains(word)) {
                    startRow = palabraVertical.indexOf(word) + 1; //Variable que almacenara la ubicacion de la fila en la que se encontro la primera letra de la palabra
                    startCol = colIndice + 1; // Variable que almacena la ubicacion de la columna de inicio de la palabra encontrada
                    contains = true; // si encuentra la palabra se asignara true
                    break;// cuando encuentre la palabra finaliza la busqueda
                }
                colIndice++;
            }
        }

        // Aqui estaba haciendo una prueba de devolucion del  objeto JSON  con los datos encontrados
        Map<String, Object> respuesta = new HashMap<>(); //creando un map clave valor
        respuesta.put("searchword", searchword);
        respuesta.put("rows", rows);
        respuesta.put("word", word);
        respuesta.put("contains", contains);
        respuesta.put("start_row", startRow);
        respuesta.put("start_col", startCol);

        // Probando devolucion de la respuesta HTTP adecuada
        return ResponseEntity.ok(respuesta);
    }
}

