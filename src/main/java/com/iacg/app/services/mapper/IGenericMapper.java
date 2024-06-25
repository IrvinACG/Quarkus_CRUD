package com.iacg.app.services.mapper;

/**
 * Interfaz que contiene los metodos para mapear de un Entity a un DTO
 * y vicevers
 * @param <T> clase de tipo Entity
 * @param <R> clase de tipo DTO
 * 
 * @author IACG
 */
public interface IGenericMapper <T, R> {
	
	/**
	 * Metodo que mapea de un Entity a DTO
	 * @param entity objeto de tipo Entity
	 * @return R DTO
	 */
	R toDto(T entity);
	
	/**
	 * Metodo que mapea de un DTO a Entity
	 * @param dto objeto de tipo DTO
	 * @return T entity
	 */
	T toEntity(R dto);
	
	/**
	 * Metodo que actualiza la informacion de un Entity, atraves de
	 * un objeto DTO
	 * @param entity objeto de tipo Entity
	 * @param dto objeto de tipo DTO
	 * @return T entity
	 */
	T updateEntity(T entity, R dto);
	
}//Fin de clase
