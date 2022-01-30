package com.eurovision.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.eurovision.domain.Pais;
import com.eurovision.domain.Persona;


@Service
public interface PaisService {
	
	public List<Pais> findAllPaises();

	public void guardarPais(Pais pais);
	
	public void deletePais(Pais pais);
	
	public void alternarEstado(Pais pais);
}
