package com.iacg.app.services;

import java.util.Objects;

import com.iacg.app.services.dto.GenericListDTO;
import com.iacg.app.services.mapper.IGenericMapper;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;

/**
 * Clase de servicio generico, que contiene los metodos basicos de un CRUD
 * @param <T> Clase de tipo Entity
 * @param <ID> Identificador de Entity
 * @param <R> Clase de tipo DTO
 * 
 * @author IACG
 */
@NoArgsConstructor
@Transactional
public class GenericService<T, ID, R> implements IGenericService<T, ID, R>{
	
	/**
	 * Variable repository
	 */
	PanacheRepositoryBase<T, ID> repository;
	
	/**
	 * Varaible mapper
	 */
	IGenericMapper<T, R> mapper;
	
	/**
	 * Constructor de clase
	 * @param mapper objeto generico para mapear datos
	 * @param repository objeto generico que persiste los datos
	 */
	public GenericService(IGenericMapper<T, R> mapper, PanacheRepositoryBase<T, ID> repository){
		this.mapper = mapper;
		this.repository = repository;
	}
	
	/**
	 * Metodo que guarda informacion
	 * @param dto objeto DTO que contiene la informacion a guardar
	 * @return R DTO
	 */
	@Override
	public R save(R dto) {
		T entity = mapper.toEntity(dto);
		repository.persist(entity);
		return mapper.toDto(entity);
	}

	/**
	 * Metodo que busca un objeto por su identificador
	 * @param id identificador
	 * @return R DTO
	 */
	@Override
	public R findById(ID id) {
		T entity = repository.findById(id);
		if(Objects.isNull(entity)) {
			return null;
		}
		return mapper.toDto(entity);
	}

	/**
	 * Metodo que lista objetos, por medio de paginacion y ordenamiento
	 * @param page pagina actual
	 * @param size tamano de elementos por pagina
	 * @param sorted parametro de ordenamiento
	 * @return GenericListDTO
	 */
	@Override
	public GenericListDTO<T, R> findAll(int page, int size, String sorted) {
		//Paginacion
		Page p = new Page(page -1, size);
		//Ordenamiento
		Sort sort = null;
		if(Objects.nonNull(sorted)){
			sort = Sort.ascending(sorted);
		}
		return new GenericListDTO<>(repository.findAll(sort).page(p), mapper);
	}

	/**
	 * Metodo que actualiza la informacion de un objeto, el cual es buscado
	 * por su identificador
	 * @param id identificador
	 * @param dto clase de tipo DTO
	 * @return DTO
	 */
	@Override
	public R update(ID id, R dto) {
		T entity = repository.findById(id);
		if(Objects.isNull(entity)) {
			return null;
		}
		T entityUpdate = mapper.updateEntity(entity, dto);
		repository.persist(entityUpdate);
		return mapper.toDto(entityUpdate);
	}

	/**
	 * Metodo que elimina un objeto, el cual es buscado por su identificador
	 * @param id identificador
	 * @return boolean
	 */
	@Override
	public boolean delete(ID id) {
		return repository.deleteById(id);
	}
}
