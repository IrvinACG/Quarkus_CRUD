package com.iacg.app.services.dto;

import java.util.List;

import com.iacg.app.services.mapper.IGenericMapper;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import lombok.Getter;
import lombok.ToString;

/**
 * Clase generica para generar un listado de una clase, con paginacion
 * 
 * @param <T> Clase de tipo Entity
 * @param <R> Clase de tipo DTO
 * 
 * @author IACG
 */
@Getter
@ToString
public class GenericListDTO<T, R> {

	/**
	 * Variable pagination
	 */
	private PaginationDTO pagination;
	
	/**
	 * Variable data
	 */
	private List<R> data;
	
	/**
	 * Constructor de clase
	 * @param query contiene informacion de listado
	 * @param mapper objeto que ayuda a mapear de Entity a DTO
	 */
	public GenericListDTO(PanacheQuery<T> query, IGenericMapper<T, R> mapper) {
		this.data = query.list().stream().map(mapper::toDto).toList();
		this.pagination = new PaginationDTO(query.page().size, 
								query.page().index + 1, 
								query.pageCount(), 
								query.hasNextPage(), 
								query.hasPreviousPage());
	}
	
}//Fin de clase
