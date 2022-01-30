package com.eurovision.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurovision.domain.Pais;
import com.eurovision.domain.PaisRepository;
import com.eurovision.domain.Persona;
import com.eurovision.domain.PersonaRepository;
import com.eurovision.domain.PuntosPersonaPais;
import com.eurovision.domain.PuntosPersonaPaisRepository;
import com.eurovision.service.IndexService;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private PuntosPersonaPaisRepository puntosPersonaPaisRepository;
	
	
	public void inicializar() {
		
		List<Persona> personas = Stream.of(
				new Persona("Sky", "Pablo"),
				new Persona("Pablito", "Pabrito"),
				new Persona("Cesx", "Cesar"),
				new Persona("juanve", "Juan")
				)
				.collect(Collectors.toList());
		
		personaRepository.saveAll(personas);
		
		
		List<Pais> paises = Stream.of(
				new Pais("España"),
				new Pais("Suecia"),
				new Pais("Finlandia"),
				new Pais("Italia")
				)
				.collect(Collectors.toList());
		
		paisRepository.saveAll(paises);
		
		List<PuntosPersonaPais> votos = Stream.of(
				new PuntosPersonaPais(personas.get(0), paises.get(0), 10),
				new PuntosPersonaPais(personas.get(0), paises.get(1), 10),
				new PuntosPersonaPais(personas.get(0), paises.get(2), 10),
				new PuntosPersonaPais(personas.get(0), paises.get(3), 10),
				new PuntosPersonaPais(personas.get(1), paises.get(0), 30),
				new PuntosPersonaPais(personas.get(1), paises.get(1), 30),
				new PuntosPersonaPais(personas.get(1), paises.get(2), 30),
				new PuntosPersonaPais(personas.get(1), paises.get(3), 30)
				)
				.collect(Collectors.toList());
		
		puntosPersonaPaisRepository.saveAll(votos);
	}
	
	public List<Persona> getAllPersonas()  {
		return personaRepository.findAll();
	}
	
	public List<Pais> getAllPaises()  {
		return paisRepository.findAll();
	}

	@Override
	public Persona findById(Integer id) {
		return personaRepository.findById(id).orElse(null);
	}
}
