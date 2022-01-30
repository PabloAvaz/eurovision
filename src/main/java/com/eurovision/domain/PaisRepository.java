package com.eurovision.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer>{

	Pais findByNombre(String nombre);
}
