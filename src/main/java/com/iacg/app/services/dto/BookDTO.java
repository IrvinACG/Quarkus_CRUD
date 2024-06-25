package com.iacg.app.services.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase DTO que contiene informacion del tipo Libro
 * 
 * @author IACG
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {

	/**
	 * Variable 
	 */
	private Long id;
	
	/**
	 * Variable 
	 */
	@NotBlank
	private String title;
	
	/**
	 * Variable 
	 */
	@Min(value = 1)
	private int numPages;
	
	/**
	 * Variable 
	 */
	@NotNull
	private LocalDate pubDate;
	
	/**
	 * Variable 
	 */
	@NotBlank
	private String description;
	
}//Fin de clase
