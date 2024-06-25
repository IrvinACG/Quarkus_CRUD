package com.iacg.app.repositories.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase de tipo entidad de libro
 * 
 * @author IACG
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class BookEntity {

	/**
	 * Variable id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	/**
	 * Variable title
	 */
	@Column
	private String title;
	
	/**
	 * Variable numPages
	 */
	@Column(name = "number_pages")
	private int numPages;
	
	/**
	 * Variable pubDate
	 */
	@Column(name = "publication_date")
	private LocalDate pubDate;
	
	/**
	 * Variable description
	 */
	@Column
	private String description;
	
	/**
	 * Variable createdAt
	 */
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	/**
	 * Variable updatedAt
	 */
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
}//Fin de clase
