package com.iacg.app.services;

import com.iacg.app.repositories.BookRepository;
import com.iacg.app.repositories.entities.BookEntity;
import com.iacg.app.services.dto.BookDTO;
import com.iacg.app.services.mapper.BookMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;

/**
 * Clase de sevicio, que contiene los metodos necesarios para manejar la logica de negocio,
 * asocido a libros.
 * Extiende de la clase @GenericService que contiene los metodo basicos de un CRUD
 * 
 * @author IACG
 */
@NoArgsConstructor
@ApplicationScoped
public class BookService extends GenericService<BookEntity, Long, BookDTO>{
		
	/**
	 * Constructor de clase
	 * @param mapper objeto para mapear datos
	 * @param repository objeto que persiste los datos
	 */
	@Inject
	public BookService(BookMapper mapper, BookRepository repository) {
		super(mapper, repository);
	}
	
}//Fin de clase
