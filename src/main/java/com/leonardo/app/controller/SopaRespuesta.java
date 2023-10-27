package com.leonardo.app.controller;

// Se crea la clase que tendra los datos que se entregaran al JSON como respuesta
public class SopaRespuesta {
	// palabra con los caracteres del array que se busco
    private String searchword;
    // la cantidad de filas del array
    private int rows;
    // la palabra buscada
    private String word;
    // Entrega la respuesta de si encontro o no la palabra (true/false)
    private boolean contains;
    // indica la fila donde inicia la palabra si la encontro
    private int start_row;
    // indica la columna de la palabra si la encontro
    private int start_col;
    
    
 // constructor, getters y setters de la clase para obtener y asignar los valores con las funciones del controlador
	
	public SopaRespuesta() {
	}

    public String getSearchword() {
        return searchword;
    }
	
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public boolean isContains() {
		return contains;
	}
	
	public void setContains(boolean contains) {
		this.contains = contains;
	}
	
	public int getStart_row() {
		return start_row;
	}
	
	public void setStart_row(int start_row) {
		this.start_row = start_row;
	}
	
	public int getStart_col() {
		return start_col;
	}
	
	public void setStart_col(int start_col) {
		this.start_col = start_col;
	}
    
    

    
}