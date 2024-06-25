package com.iacg.app.services.mapper;

import java.util.Objects;

import com.iacg.app.repositories.entities.BookEntity;
import com.iacg.app.services.dto.BookDTO;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Clase de tipo Mapper que contiene los metodos para mepear de un
 * BookEntity a BookDTO y viceversa
 * 
 * @author IACG
 */
@ApplicationScoped
public class BookMapper implements IGenericMapper<BookEntity, BookDTO>{

	/**
	 * Metodo que mapea de un Entity a DTO
	 * @param entity objeto de tipo BookEntity
	 * @return BookDTO DTO
	 */
	public BookDTO toDto(BookEntity entity) {
		BookDTO dto = new BookDTO();
		if(Objects.isNull(entity)) {
			return null;
		}
		dto.setId(entity.getId());
		dto.setDescription(entity.getDescription());
		dto.setNumPages(entity.getNumPages());
		dto.setPubDate(entity.getPubDate());
		dto.setTitle(entity.getTitle());
		return dto;
	}
	
	/**
	 * Metodo que mapea de un DTO a Entity
	 * @param dto objeto de tipo BookDTO
	 * @return BookEntity entity
	 */
	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();
		if(Objects.isNull(dto)) {
			return null;
		}
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setNumPages(dto.getNumPages());
		entity.setPubDate(dto.getPubDate());
		return entity;
	}

	/**
	 * Metodo que actualiza la informacion de un Entity, atraves de
	 * un objeto DTO
	 * @param entity objeto de tipo BookEntity
	 * @param dto objeto de tipo BookDTO
	 * @return BookEntity entity
	 */
	@Override
	public BookEntity updateEntity(BookEntity entity, BookDTO dto) {
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setNumPages(dto.getNumPages());
		entity.setPubDate(dto.getPubDate());
		return entity;
	}
	
}//Fin de clase
