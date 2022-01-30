package com.eurovision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eurovision.domain.PaisRepository;
import com.eurovision.service.PaisService;
import com.eurovision.service.PersonaService;

@Controller
@RequestMapping("/paises")
public class PaisesController {
	
	@Autowired
	PaisService paisServiceImpl;
	
	@GetMapping("/")
	public String indexPersonas(Model model) {
		model.addAttribute("paises", paisServiceImpl.findAllPaises());
		return "paises/listado-paises";
	}
}
