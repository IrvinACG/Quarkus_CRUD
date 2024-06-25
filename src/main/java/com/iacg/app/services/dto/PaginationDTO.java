package com.iacg.app.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase DTO que contiene informacion de la paginacion
 * 
 * @author IACG
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginationDTO {
	
	/**
	 * Variable size
	 */
	private int size;

	/**
	 * Variable page
	 */
	private int page;
	
	/**
	 * Variable totalPages
	 */
	private int totalPages;
	
	/**
	 * Variable hasNextPage
	 */
	private boolean hasNextPage;
	
	/**
	 * Variable hasPreviousPage
	 */
	private boolean hasPreviousPage;
	
}//Fin de clase
