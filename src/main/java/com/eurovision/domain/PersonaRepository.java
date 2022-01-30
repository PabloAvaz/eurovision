package com.eurovision.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
	Persona findByApodo(String apodo);

}
