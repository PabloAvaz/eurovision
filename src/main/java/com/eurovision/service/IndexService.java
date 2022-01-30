package com.eurovision.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.eurovision.domain.Pais;
import com.eurovision.domain.Persona;

@Service
public interface IndexService {
	
	public void inicializar();
	
	public List<Persona> getAllPersonas();
	
	public List<Pais> getAllPaises();
}
