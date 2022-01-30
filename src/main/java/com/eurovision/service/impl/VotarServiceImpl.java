package com.eurovision.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurovision.domain.Pais;
import com.eurovision.domain.PaisRepository;
import com.eurovision.domain.Persona;
import com.eurovision.domain.PersonaRepository;
import com.eurovision.domain.PuntosPersonaPais;
import com.eurovision.domain.PuntosPersonaPaisRepository;
import com.eurovision.service.VotarService;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class VotarServiceImpl implements VotarService {
	
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private PuntosPersonaPaisRepository puntosPersonaPaisRepository;

	@Override
	public List<PuntosPersonaPais> findAllVotosByPersona(Persona persona)  {
		return puntosPersonaPaisRepository.findByPersona(persona);
	}

	@Override
	public void guardarVotacion(PuntosPersonaPais puntosPersonaPais) {
		Optional<Pais> optionalPais = paisRepository.findById(puntosPersonaPais.getPais().getId());
		Optional<Persona> optionalPersona = personaRepository.findById(puntosPersonaPais.getPersona().getId());
		if (optionalPais.isPresent() && optionalPersona.isPresent());
			PuntosPersonaPais votacion = new PuntosPersonaPais(optionalPersona.get(), optionalPais.get(), puntosPersonaPais.getPuntos());
			puntosPersonaPaisRepository.save(votacion);
		
	}
	

}
