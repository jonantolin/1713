package com.ipartek.formacion;

public class PersonException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String ERROR_EDAD = "Debe ser una edad v�lida (mayor que 0)";
	public final static String ERROR_ALTURA = "Debe ser una altura v�lida( mayor que 0)";
	
	public PersonException(String error) {
		super(error);
	}

}
