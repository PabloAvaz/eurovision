package com.eurovision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eurovision.service.IndexService;

import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/")
@NoArgsConstructor
public class IndexController {
	@Autowired
	private IndexService indexServiceImpl;

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
}
