package eus.birt.dam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Libro;
import eus.birt.dam.repository.LibroRepository;
import eus.birt.dam.repository.EditorialRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/libros")
public class LibroController {

	@Autowired
	LibroRepository 	libroRepository;
	
	@Autowired
	EditorialRepository editorialRepository;
		
	@GetMapping({"/",""})
	public List <Libro> index() {
		return libroRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Libro show(@PathVariable("id") Long id) {
		return libroRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Libro create(@RequestBody Libro libro) {
		return libroRepository.save(libro);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Libro update(@RequestBody Libro libro, @PathVariable("id") Long id) {
		Libro tempLibro = libroRepository.findById(id).orElse(null);
		
		tempLibro.setTitulo(libro.getTitulo());
		tempLibro.setAutor(libro.getAutor());
		tempLibro.setGenero(libro.getGenero());
		tempLibro.setFechapublicacion(libro.getFechapublicacion());
		tempLibro.setEditorial(libro.getEditorial());
		
		return libroRepository.save(tempLibro);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		libroRepository.deleteById(id);
	}
	
}