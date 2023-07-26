package com.codingdojo.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.project.models.Hobby;
import com.codingdojo.project.models.Usuario;
import com.codingdojo.project.services.UsuariosService;

@Controller
public class ControladorHobbies {

	
	@Autowired
	private UsuariosService service;
	
	@GetMapping("/asignar/{id}")
	public String asignar(@PathVariable("id")Long id, Model model) {
		
		List<Hobby> hobbies = service.findHobbies();
		model.addAttribute("hobbies", hobbies);
		
		Usuario usuario = service.findUsuario(id);
		model.addAttribute("usuario", usuario);
		
		model.addAttribute("hobbiesNoPertenece", service.findHobbiesSinUsuario(id));
		
		return "/hobbies/assign.jsp";
	}
	
	@PostMapping("/assignHobby")
	public String asignarHooby(@RequestParam("user_id")Long user_id,
								@RequestParam("hobby_id")Long hobby_id) {
		
		service.saveUsuarioHobby(user_id, hobby_id);
		
		return "redirect:/dashboard";
	}
}
