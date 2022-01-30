package com.eurovision.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eurovision.domain.Pais;
import com.eurovision.domain.PaisRepository;
import com.eurovision.domain.Persona;
import com.eurovision.service.PaisService;
import com.eurovision.service.PersonaService;

@Controller
@RequestMapping("/admin/paises")
public class PaisesController {
	
	@Autowired
	PaisService paisServiceImpl;
	
	@GetMapping("/")
	public String indexPersonas(Model model) {
		model.addAttribute("paises", paisServiceImpl.findAllPaises());
		return "paises/listado-paises";
	}
	
	@GetMapping("/create")
	public String addPais(Pais pais, Model model) {
		model.addAttribute("pais", new Persona());
		return "paises/pais-form";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public String guardarPais(Pais pais) {
		paisServiceImpl.guardarPais(pais);
		return "bien";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePersona(Pais pais, Model model) {
		paisServiceImpl.deletePais(pais);
		return "redirect:/admin/paises/";
	}
	
	@GetMapping("/alternarEstado/{id}")
	public String alternarPais(Pais pais, Model model) {
		paisServiceImpl.alternarEstado(pais);
		return "redirect:/admin/paises/";
	}
}
