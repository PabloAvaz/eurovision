package com.eurovision.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurovision.domain.Pais;
import com.eurovision.domain.PaisRepository;
import com.eurovision.domain.Persona;
import com.eurovision.domain.PuntosPersonaPais;
import com.eurovision.domain.PuntosPersonaPaisRepository;
import com.eurovision.service.PaisService;
import com.eurovision.service.VotarService;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class VotarServiceImpl implements VotarService {
	
	@Autowired
	private PuntosPersonaPaisRepository puntosPersonaPaisRepository;

	@Override
	public List<PuntosPersonaPais> findAllVotosByPersona(Persona persona)  {
		return puntosPersonaPaisRepository.findByPersona(persona);
	}
	

}
