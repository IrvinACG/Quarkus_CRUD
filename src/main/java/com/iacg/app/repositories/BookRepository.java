package com.iacg.app.repositories;

import com.iacg.app.repositories.entities.BookEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Clase de tipo repositorio que cotiene los metodos de persistencia, 
 * asociado a la entidad: BookEntity
 * 
 * @author IACG
 */
@ApplicationScoped
public class BookRepository implements PanacheRepositoryBase<BookEntity, Long>{

}//Fin de clase
