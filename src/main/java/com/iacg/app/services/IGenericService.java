package com.iacg.app.services;

import com.iacg.app.services.dto.GenericListDTO;

/**
 * Interfaz que contiene los metodos de un CRUD generico
 * @param <T> Clase de tipo Entity
 * @param <ID> Identificador de Entity
 * @param <R> Clase de tipo DTO
 */
public interface IGenericService <T, ID, R>{

	/**
	 * Metodo que guarda informacion
	 * @param dto objeto DTO que contiene la informacion a guardar
	 * @return R DTO
	 */
	R save(R dto);
	
	/**
	 * Metodo que busca un objeto por su identificador
	 * @param id identificador
	 * @return R DTO
	 */
	R findById(ID id);
	
	/**
	 * Metodo que lista objetos, por medio de paginacion y ordenamiento
	 * @param page pagina actual
	 * @param size tamano de elementos por pagina
	 * @param sorted parametro de ordenamiento
	 * @return GenericListDTO
	 */
	GenericListDTO<T, R> findAll(int page, int size, String sorted);
	
	/**
	 * Metodo que actualiza la informacion de un objeto, el cual es buscado
	 * por su identificador
	 * @param id identificador
	 * @param dto clase de tipo DTO
	 * @return DTO
	 */
	R update(ID id, R dto);
	
	/**
	 * Metodo que elimina un objeto, el cual es buscado por su identificador
	 * @param id identificador
	 * @return boolean
	 */
	boolean delete(ID id);
	
}
