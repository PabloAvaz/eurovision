
package com.eurovision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eurovision.domain.Pais;
import com.eurovision.domain.Persona;
import com.eurovision.domain.PuntosPersonaPais;
import com.eurovision.service.VotarService;

@Controller
@RequestMapping("/accion/votar")
public class VotarController {
	
	@Autowired
	private VotarService votarServiceImpl;
	
	@GetMapping("/")
	public String votar(Model model) {
		model.addAttribute("votos", votarServiceImpl.obtenerVotosPaisesActivos(new Persona()));
		return "votar/votar";
	}
	
	@GetMapping("/{id}")
	public String votar(Persona persona, Model model) {
		model.addAttribute("personaId", persona.getId());
		model.addAttribute("votos", votarServiceImpl.findAllVotosByPersona(persona));

		model.addAttribute("votoUsuario", new PuntosPersonaPais());
		return "votar/votar-detalle";
	}
	
	@PostMapping("/guardarVoto")
	@ResponseBody
	public String guardarVotacion(PuntosPersonaPais votoUsuario) {
		votarServiceImpl.guardarVotacion(votoUsuario);
		return "Guardado";
	}
	

}
