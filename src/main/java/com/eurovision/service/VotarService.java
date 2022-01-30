package com.eurovision.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.eurovision.domain.Pais;
import com.eurovision.domain.Persona;
import com.eurovision.domain.PuntosPersonaPais;
import com.eurovision.dto.VotoDto;


@Service
public interface VotarService {
	
	List<PuntosPersonaPais> findAllVotosByPersona(Persona persona);	
	
	List<VotoDto> obtenerVotosPaisesActivos(Persona persona);	
	
	void guardarVotacion(PuntosPersonaPais puntosPersonaPais);
	
	PuntosPersonaPais findFavorito(Persona persona);
}
