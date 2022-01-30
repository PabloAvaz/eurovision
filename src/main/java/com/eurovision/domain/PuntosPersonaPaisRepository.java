package com.eurovision.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntosPersonaPaisRepository extends JpaRepository<PuntosPersonaPais, Integer>{
	
	List<PuntosPersonaPais> findByPersona(Persona persona);
}
