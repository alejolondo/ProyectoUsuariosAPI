package com.codingdojo.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.project.services.UsuariosService;

@Controller
public class ControladorSalones {
	
	@Autowired
	private UsuariosService service;
	
	
	@GetMapping("/salones")
	public String salones(Model model) {
		
		model.addAttribute("salones", service.findSalones());
		
		return "/salones/index.jsp";
	}
	
	@GetMapping("salon/{id}")
	public String salon( @PathVariable("id")Long id, Model model) {
		
		model.addAttribute("salon", service.findSalon(id));
		return "/salones/show.jsp";
	}

}
