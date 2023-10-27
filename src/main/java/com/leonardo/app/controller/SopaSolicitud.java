package com.leonardo.app.controller;

// Creo una clase la cual recibira los parametros de la solicitud JSON  y los asigno a cada atributo para poderlos trabajar en el controlador
public class SopaSolicitud {
	//Atributos de la solicitud
    private String searchword;
    private int rows;
    private String word;
    
    
 // Creo los getters y setters para poder acceder a los atributos de la clase
    
    //obtiene el string de la clase
	public String getSearchword() {
		return searchword;
	}
	//asigna la palabra con los caracteres a buscar en la clase
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	//obtiene las filas de la clase
	public int getRows() {
		return rows;
	}
	//Asigna las filas al atributo de la clase
	public void setRows(int rows) {
		this.rows = rows;
	}
	//obtiene la palabra de la clase
	public String getWord() {
		return word;
	}
	// asigna la palabra al atributo de la clase
	public void setWord(String word) {
		this.word = word;
	}  
    
}