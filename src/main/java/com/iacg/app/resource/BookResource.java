package com.iacg.app.resource;

import java.net.URI;
import java.util.Objects;

import com.iacg.app.services.BookService;
import com.iacg.app.services.dto.BookDTO;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * Clase de Recurso que contiene los diferentes endpoints de la api
 * asociada a libros
 * 
 * @author IACG
 */
@Path("/api/libros")
public class BookResource {

	/**
	 * Variable service
	 */
	private BookService service;
	
	@Inject
	public BookResource(BookService service) {;
		this.service = service;
	}
	
	/**
	 * Endpoint con verbo HTTP POST, encargado de guardar informacion
	 * asociado a libros
	 * @param book libro
	 * @return Response
	 */
	@POST
	public Response save(@Valid BookDTO book){
		BookDTO dto = service.save(book);
		return Response.created(URI.create("/api/libros/" + dto.getId()))
				.entity(dto)
				.build();
	}
	
	/**
	 * Endpoint con verbo HTTP GET, encargado de listar todos los libros,
	 * la cual tiene paginacion incluida
	 * @param page pagina actual
	 * @param size tamano de elementos por pagina
	 * @param sorted ordenamiento
	 * @return Response
	 */
	@GET
	public Response findAll(@QueryParam("page") @DefaultValue("1") int page, 
			 @DefaultValue("5") @QueryParam("size") int size,
			 @DefaultValue("id") @QueryParam("sorted") String sorted) {	
		return Response.ok(service.findAll(page, size, sorted)).build();
	}
	
	/**
	 * Endpoint con verbo HTTP GET, encargado de buscar un libro
	 * por su identificado
	 * @param id identificador
	 * @return Response
	 */
	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		BookDTO dto = service.findById(id);
		if(Objects.isNull(dto)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(dto).build();
	}
		
	/**
	 * Endpoint con verbo HTTP PUT, encargado de actualizar la informacion
	 * asociada a un libro, que se busca por su identificador 
	 * @param id identificador
	 * @param book libro
	 * @return Response
	 */
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") Long id, @Valid BookDTO book) {
		BookDTO dto = service.update(id, book);
		if(Objects.isNull(dto)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.created(URI.create("/api/libros/" + dto.getId()))
				.entity(dto)
				.build();
	}

	/**
	 * Endpoint con verbo HTTP DELETE, encargado de eliminar a un libro
	 * por su identidicador
	 * @param id identificador
	 * @return Response
	 */
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		boolean deleted = service.delete(id);
		if(!deleted) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.noContent().build();
	}
}
