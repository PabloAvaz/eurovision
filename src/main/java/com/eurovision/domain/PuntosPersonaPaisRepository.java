package com.eurovision.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eurovision.dto.VotoDto;

public interface PuntosPersonaPaisRepository extends JpaRepository<PuntosPersonaPais, Integer>{
	
	List<PuntosPersonaPais> findByPersona(Persona persona);
	
	PuntosPersonaPais findFirstByPersonaOrderByPuntosDesc(Persona persona);
	
	@Query(value = "SELECT new com.eurovision.dto.VotoDto(pp.id, pa.id, pa.nombre, pp.puntos) "
			+ " FROM Pais pa "
			+ " LEFT JOIN PuntosPersonaPais pp "
			+ " 	ON pa.id = pp.pais "
			+ " 	AND pa.activo = :activo "
			+ " 	AND pp.persona.id = :#{#persona.id} ")
	List<VotoDto> findVotosByPersona(Persona persona, Boolean activo);
}
