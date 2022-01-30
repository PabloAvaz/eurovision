package com.eurovision.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eurovision.domain.Persona;
import com.eurovision.service.IndexService;

import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/")
@NoArgsConstructor
public class IndexController extends BaseController {
	@Autowired
	private IndexService indexServiceImpl;

	@ModelAttribute(name = "personasActivas")
	public List<Persona> personasActivas(Model model) {
		return indexServiceImpl.getAllPersonas();
	}
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		model.addAttribute("personas", indexServiceImpl.getAllPersonas());
		model.addAttribute("paises", indexServiceImpl.getAllPaises());
		return "index";
	}
	
	@GetMapping("/inicializar")
	@ResponseBody
	public String inicialziar() {
		indexServiceImpl.inicializar();
		return "Bien";
	}
	
	@PostMapping("/cambioPersona")
	public String cambioPersona(Integer cambioPersonaId) { 
		System.out.println("Cambiando a " + cambioPersonaId);
		//TODO PVS SESION cambiar usuario
		return "redirect:/";
	}
}
