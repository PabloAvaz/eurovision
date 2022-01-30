
package com.eurovision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eurovision.domain.Persona;
import com.eurovision.service.VotarService;

@Controller
@RequestMapping("/votar")
public class VotarController {
	
	@Autowired
	private VotarService votarServiceImpl;
	
	@GetMapping("/")
	public String votar(Model model) {
		return "votar/votar";
	}
	
	@GetMapping("/{id}")
	public String votar(Persona persona, Model model) {
		model.addAttribute("votos", votarServiceImpl.findAllVotosByPersona(persona));
		return "votar/votar-detalle";
	}
}
