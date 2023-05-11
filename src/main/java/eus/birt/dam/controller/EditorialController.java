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

import eus.birt.dam.domain.Editorial;
import eus.birt.dam.repository.EditorialRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/editoriales")
public class EditorialController {

@Autowired
EditorialRepository editorialRepository;
	
	@GetMapping({"/",""})
	public List <Editorial> index() {
	return editorialRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Editorial show(@PathVariable("id") Long id) {
		return editorialRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Editorial create(@RequestBody Editorial editorial) {
		return editorialRepository.save(editorial);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Editorial update(@RequestBody Editorial editorial, @PathVariable("id") Long id) {
		Editorial tempEditorial = editorialRepository.findById(id).orElse(null);
		
		tempEditorial.setNombre(editorial.getNombre());
		tempEditorial.setCiudad(editorial.getCiudad());
		tempEditorial.setPais(editorial.getPais());
		tempEditorial.setManager(editorial.getManager());
		//Al ser un id diferente, el método save hace en realidad un update
		return editorialRepository.save(tempEditorial);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		editorialRepository.deleteById(id);
	}
	
}
