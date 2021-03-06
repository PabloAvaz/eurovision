package com.eurovision.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eurovision.domain.Persona;
import com.eurovision.service.PersonaService;

@Controller
@RequestMapping("/admin/personas")
public class PersonasController {
	
	@Autowired
	PersonaService personaServiceImpl;
	
	@GetMapping("/")
	public String indexPersonas(Model model) {
		model.addAttribute("personas", personaServiceImpl.findAllPersonas());
		return "personas/listado-personas";
	}
	
	@GetMapping("/create")
	public String addPersona(Persona persona, Model model) {
		model.addAttribute("persona", new Persona());
		return "personas/persona-form";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public String guardarPersona(Persona persona) {
		personaServiceImpl.guardarPersona(persona);
		return "bien";
	}
	
	@GetMapping("/edit/{id}")
	public String editPersona(@PathVariable Integer id, Model model) {
		model.addAttribute("persona", personaServiceImpl.findById(id));
			return "personas/persona-form";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePersona(Persona persona, Model model) {
		personaServiceImpl.deletePersona(persona);
		return "redirect:/admin/personas/";
	}
	
	@GetMapping("/alternarEstado/{id}")
	public String alternarEstado(Persona persona, Model model) {
		personaServiceImpl.alternarEstado(persona);
		return "redirect:/admin/personas/";
	}
	
}
