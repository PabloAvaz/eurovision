package com.eurovision.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurovision.domain.Persona;
import com.eurovision.domain.PersonaRepository;
import com.eurovision.service.PersonaService;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PaisServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> findAllPersonas()  {
		return personaRepository.findAll();
	}


	@Override
	public void guardarPersona(Persona persona) {
		if (personaRepository.findByApodo(persona.getApodo()) == null) {
			personaRepository.save(persona);
		}	
	}


	@Override
	public void alternarEstado(Persona persona) {
		Optional<Persona> optionalPersonaEntity = personaRepository.findById(persona.getId());
		if (optionalPersonaEntity.isPresent()) {
			Persona personaEntity = optionalPersonaEntity.get();
			personaEntity.setActiva(!personaEntity.getActiva());
			personaRepository.save(personaEntity);
		}
	}


	@Override
	public void deletePersona(Persona persona) {
		personaRepository.deleteById(persona.getId());
	}
	

}
