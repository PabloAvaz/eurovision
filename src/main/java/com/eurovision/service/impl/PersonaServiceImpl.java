package com.eurovision.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurovision.domain.Pais;
import com.eurovision.domain.PaisRepository;
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
	

}
