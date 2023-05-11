package eus.birt.dam.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="libro")
public class Libro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="genero")
	private String genero;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fechapublicacion;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn (name = "editorial_id")
	private Editorial editorial;

	//Añade propiedad teamName a JSON 
	@JsonProperty("EditorialName")
	public String getEditorialName() {
	    return editorial != null ? editorial.getNombre() : null;
	}

	public Libro(String titulo, String autor, String genero, LocalDate fechapublicacion, Editorial editorial) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.fechapublicacion = fechapublicacion;
		this.editorial = editorial;
	}
}
