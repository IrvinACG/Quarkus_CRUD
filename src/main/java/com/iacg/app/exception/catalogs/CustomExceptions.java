package com.iacg.app.exception.catalogs;

import jakarta.ws.rs.core.Response.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Clase que contiene diferentes errores personalizados
 * 
 * @author IACG
 */
@Getter
@AllArgsConstructor
public enum CustomExceptions {

	/**
	 * Excepcion personalizada: Error generico de servidor
	 */
	CSTEXP01("Error generico de servidor", Status.INTERNAL_SERVER_ERROR, LevelException.ERROR),
	
	/**
	 * Excepcion personalizada: Problema al enviar parametros
	 */
	CSTEXP02("Problema al enviar parametros", Status.BAD_REQUEST, LevelException.ERROR),
	
	/**
	 * Excepcion personalizada: Conflicto al realizar la operación
	 */
	CSTEXP03("Conflicto al realizar la operación", Status.BAD_REQUEST, LevelException.ERROR),
	
	/**
	 * Excepcion personalizada: Consulta duplicada
	 */
	CSTEXP04("Consulta duplicada", Status.CONFLICT, LevelException.WARN),
	
	/**
	 * Excepcion personalizada: Objeto no encontrado
	 */
	CSTEXP05("Objeto no encontrado", Status.NOT_FOUND, LevelException.WARN);
	
	/**
	 * Variable description
	 */
	private final String description;
	
	/**
	 * Variable status
	 */
	private final Status status;
	
	/**
	 * Variable levelExption
	 */
	private final LevelException levelExption;
}//Fin de clase
