package com.iacg.app.exception;

import com.iacg.app.exception.catalogs.CustomExceptions;

/**
 * Clase de excepcion personalizada
 * 
 * @author IACG
 */
public class CustomException extends HandlerExcepction{

	/**
	 * Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor de clase
	 * @param e tipo de excepcion personalizada
	 */
	public CustomException(CustomExceptions e) {
		super(null, e.getDescription(), e.getStatus(), e.getLevelExption());
	}
	
	/**
	 * Constrcutor de clase
	 * @param e tipo de excepcion personalizada
	 * @param message mensaje de error
	 */
	public CustomException(CustomExceptions e, String message) {
		super(message, e.getDescription(), e.getStatus(), e.getLevelExption());
	}
	
}//Fin de clase
