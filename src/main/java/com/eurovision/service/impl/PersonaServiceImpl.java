package com.eurovision.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurovision.domain.Pais;
import com.eurovision.domain.PaisRepository;
import com.eurovision.domain.Persona;
import com.eurovision.service.PaisService;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PersonaServiceImpl implements PaisService {
	
	@Autowired
	private PaisRepository paisRepository;

	
	public List<Pais> findAllPaises()  {
		return paisRepository.findAll();
	}

	@Override
	public void guardarPais(Pais pais) {
		if (paisRepository.findByNombre(pais.getNombre()) == null) {
			paisRepository.save(pais);
		}
	}

	@Override
	public void deletePais(Pais pais) {
		paisRepository.deleteById(pais.getId());
	}

	@Override
	public void alternarEstado(Pais pais) {
		Optional<Pais> optionalPais = paisRepository.findById(pais.getId());
		if (optionalPais.isPresent()) {
			Pais paisModificado = optionalPais.get();
			paisModificado.setActivo(!paisModificado.getActivo());
			paisRepository.save(paisModificado);
		}
	}
	
}
