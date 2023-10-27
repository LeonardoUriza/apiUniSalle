package com.leonardo.app.service;

import com.leonardo.app.controller.SopaSolicitud;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public class SopaService {
	
	//Se crea una funcion que toma el string con las letras y el int con las filas y crea el array de caracteres para poder buscar la palabra
    public char[][] crearSopa(SopaSolicitud solicitud) {
        String searchword = solicitud.getSearchword(); // tomo los la palabra del objeto sopaSolicitud que es el que recibe el JSON
        int rows = solicitud.getRows();  // tomo las filas en el objeto para poder crear las filas del array
        int cols = searchword.length() / rows; // para crear las columnas tomo el tamano del string y lo divido entre las filas 
        char[][] sopa = new char[rows][cols]; //Se crea la sopa
        
        //Recorro el array casilla a casilla y se coloca cada caracter del string, este me entrega la sopa de letras creada
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                sopa[i][j] = searchword.charAt(index); // con la funcion charAt tomo la leta que encuentre la extraigo del string y la coloco eb la posision indicada
            }
        }

        return sopa; // 
    }    
        
}
