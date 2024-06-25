package com.iacg.app.exception;

import java.util.List;

import com.iacg.app.exception.catalogs.CustomExceptions;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase que lanza una excepcion formateado de tipo: ConstraintViolationExceptionMapper
 * Esta clase reemplaza la excepcion que lanza quarkus por defecto.
 * 
 * @author IACG
 */
@Slf4j
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	/**
	 * Metodo que crea una respuesta personalizada en base a la excepcion
	 * @param e excepcion
	 * @return Response
	 */
	@Override
	public Response toResponse(ConstraintViolationException e) {
		List<String> messages = e.getConstraintViolations()
									.stream()
									.map(v -> "Campo: "+ getLastNodeName(v.getPropertyPath()) + ", " + v.getMessage())
									.toList();
		log.error("Error de tipo: ConstraintViolationException, error: {}", messages.toString());
		ResponseError error = new ResponseError(messages, 
												CustomExceptions.CSTEXP02.getDescription(),
												CustomExceptions.CSTEXP02.getStatus(), 
												CustomExceptions.CSTEXP02.getLevelExption());
		log.error("Status: {}",CustomExceptions.CSTEXP02.getStatus().getStatusCode());
		return Response.status(error.getStatus()).entity(error).build();
	}

	/**
	 * Metodo que obtiene el nombre del ultimo nodo, siguiendo la siguiente estructura
	 * - nodo1.nodo2.nodo3
	 * En este caso obtendria el String de nodo3
	 * @param propertyPath ruta de nodo
	 * @return String
	 */
	private String getLastNodeName(Path propertyPath) {
        String[] nodes = propertyPath.toString().split("\\.");
        return nodes[nodes.length - 1];
    }
	
}//Fin de clase
