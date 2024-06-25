package com.iacg.app.exception;

import com.iacg.app.exception.catalogs.LevelException;

import jakarta.ws.rs.core.Response.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Clase que contiene la informacion del tipo de excepcion
 * 
 * @author IACG
 */
@AllArgsConstructor
@Getter
@ToString
public class HandlerExcepction extends RuntimeException{
	
	/**
	 * Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Variable message
	 */
	private final String message;
	
	/**
	 * Variable description
	 */
	private final String description;
	
	/**
	 * Variable status
	 */
	private final Status status;
	
	/**
	 * Variable levelError
	 */
	private final LevelException levelException;
	
}//Fin de clase
