package com.codingdojo.project.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.project.models.UsuarioOld;

@Controller
public class ControladorBase {

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("nombre", "Blanca");

		return "index.jsp";
	}
	
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		
		model.addAttribute("titulo", "Bienvenido");
		
		String hobbies[] = {"nadar", "Correr", "Bailar", "Jugar Voleibol"};
		
		model.addAttribute("hobbies", hobbies);
		
		HashMap<String,String> paises = new HashMap<String, String>();
		
		paises.put("Mexico", "CDMX");
		paises.put("EEUU", "Washington DC");
		paises.put("Colombia", "Bogotá");
		paises.put("Chile", "Santiago de Chile");
		
		model.addAttribute("countries", paises);
		
		UsuarioOld usuario1 = new UsuarioOld("Helena", "De Troya",1);
		UsuarioOld usuario2 = new UsuarioOld("Pedro", "Pérez", 2);
		UsuarioOld usuario3 = new UsuarioOld("Pablo", "Rocha", 3);
		
		ArrayList<UsuarioOld> listado = new ArrayList<UsuarioOld>();
		listado.add(usuario1);
		listado.add(usuario2);
		listado.add(usuario3);
		
		model.addAttribute("usuarios", listado);
		
		
		return "usuarios.jsp";
	}
}
