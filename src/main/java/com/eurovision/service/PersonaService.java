package com.eurovision.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eurovision.domain.Persona;


@Service
public interface PersonaService {
	
	public List<Persona> findAllPersonas();
	
	public void guardarPersona(Persona persona);
	
	public void deletePersona(Persona persona);
	
	public void alternarEstado(Persona persona);
	
}
