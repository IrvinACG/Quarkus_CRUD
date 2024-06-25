package com.iacg.app.exception;
import java.util.List;

import com.iacg.app.exception.catalogs.LevelException;

import jakarta.ws.rs.core.Response.Status;
import lombok.Getter;

/**
 * Clase de respuesta de error
 * 
 * @author IACG
 */
@Getter
public class ResponseError {
	
	/**
	 * Constructor de clase
	 * @param message mensaje
	 * @param description descripcion
	 * @param status estado HTTP
	 * @param levelException nivel de error
	 */
	public ResponseError(String message, String description, Status status, LevelException levelException) {
		this.messages = null;
		this.message = message;
		this.description = description;
		this.status = status;
		this.levelException = levelException;
	}
	
	/**
	 * Constructor de clase
	 * @param messages lista de mensajes
	 * @param description descripcion
	 * @param status estado HTTP
	 * @param levelException nivel de error
	 */
	public ResponseError(List<String> messages, String description, Status status, LevelException levelException) {
		this.messages = messages;
		this.message = null;
		this.description = description;
		this.status = status;
		this.levelException = levelException;
	}
	
	/**
	 * Variable messages
	 */
	private final List<String> messages;
	
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
	private final Status  status;
	
	/**
	 * Variable 
	 */
	private final LevelException levelException;

}//Fin de clase
