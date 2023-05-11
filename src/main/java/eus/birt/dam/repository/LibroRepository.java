package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	
}