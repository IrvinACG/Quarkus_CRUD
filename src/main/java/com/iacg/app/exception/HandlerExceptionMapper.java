package com.iacg.app.exception;

import com.iacg.app.exception.catalogs.CustomExceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase que lanza una excepcion formateada dependiendo del tipo de excepcion.
 * Para capturar una nueva excepcion, en necesario crear su metodo privado y agregar
 * al metodo toResponse.
 * 
 * @author IACG
 */
@Slf4j
@Provider
public class HandlerExceptionMapper implements ExceptionMapper<Exception>{

	/**
	 * Metodo que crea una respuesta personalizada en base a la excepcion
	 * @param e excepcion
	 * @return Response
	 */
	@Override
	public Response toResponse(Exception e) {
		ResponseError error = null;
		
		if(e instanceof HandlerExcepction handlerException) {
			error = catchHandlerExcepction(handlerException);
		}else if(e instanceof WebApplicationException webAppException) {
			error = catchWebApplicationException(webAppException);
		}else {
			error = catchGenericException(e);
		}
		return Response.status(error.getStatus()).entity(error).build();
	}
	
	/**
	 * Metodo que crea una respuesta de error, en base al tipo de excepcion
	 * de tipo: WebApplicationException
	 * @param e excepcion
	 * @return ResponseError
	 */
	private ResponseError catchWebApplicationException(WebApplicationException e) {
		log.error("Error de tipo: WebApplicationException, error: {}",e.toString());
		return new ResponseError(e.getMessage(), 
								CustomExceptions.CSTEXP03.getDescription(), 
								CustomExceptions.CSTEXP03.getStatus(), 
								CustomExceptions.CSTEXP03.getLevelExption());
	}

	/**
	 * Metodo que crea una respuesta de error, en base al tipo de excepcion
	 * de tipo: HandlerExcepction
	 * @param e excepcion
	 * @return ResponseError
	 */
	private ResponseError catchHandlerExcepction(HandlerExcepction e) {
		log.error("Error de tipo: HandlerExcepction, error: {}",e.toString());
		return new ResponseError(e.getMessage(), 
								e.getDescription(), 
								e.getStatus(), 
								e.getLevelException());

	}
	
	/**
	 * Metodo que crea una respuesta de error, en base al tipo de excepcion
	 * de tipo: Exception
	 * @param e excepcion
	 * @return ResponseError
	 */
	private ResponseError catchGenericException(Exception e) {
		log.error("Error de tipo: Exception, error: {}",e.toString());
		return new ResponseError(e.getMessage(), 
								CustomExceptions.CSTEXP01.getDescription(), 
								CustomExceptions.CSTEXP01.getStatus(), 
								CustomExceptions.CSTEXP01.getLevelExption());
		
	}

}//Fin de clase
