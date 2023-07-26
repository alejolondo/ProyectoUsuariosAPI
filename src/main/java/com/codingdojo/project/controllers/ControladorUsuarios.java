package com.codingdojo.project.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.project.models.Salon;
import com.codingdojo.project.models.Usuario;
import com.codingdojo.project.services.UsuariosService;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private UsuariosService servicio;
	
	@GetMapping("/registro")
	public String registro() {
		return "registro.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		//creamos una variable para recibir la lista de usuarios
		List<Usuario> usuarios = servicio.findUsuarios();
		
		model.addAttribute("usuarios", usuarios); //enviamos atributos usuarios a dashboard
		model.addAttribute("usuariosSinSalon", servicio.findUsuariosSinSalon());
		
		return "dashboard.jsp";
	}
	
	
	
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(@RequestParam("nombre")String name, 
									@RequestParam("email") String email, 
									HttpSession session,
									RedirectAttributes flash) {
		System.out.println(name);
		System.out.println(email);
		
		if(name.equals("")) {
			flash.addFlashAttribute("Error", "Por favor proporciona tu nombre");
			return "redirect:/registro";
		}
		
		session.setAttribute("name", name);
		session.setAttribute("email", email);
		
		
		return "redirect:/dashboard"; //Hacemos la redireccion a la ruta
	}
	
	@GetMapping("/new")
	public String newUser(@ModelAttribute("usuario")Usuario usuario,
							Model model) {
		
		model.addAttribute("salones", servicio.findSalones());
		
		return "new.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("usuario")Usuario usuario, 
						BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("salones", servicio.findSalones());
			return "new.jsp";	
		}else {
			servicio.saveUsuario(usuario);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id, 
						Model model, 
						@ModelAttribute("usuario") Usuario usuario) {
		
		Usuario usuarioEdit = servicio.findUsuario(id);
		model.addAttribute("usuario", usuarioEdit);
		model.addAttribute("salones", servicio.findSalones());
		
		
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("usuario")Usuario usuario,
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("salones", servicio.findSalones());
			return "edit.jsp";
		}else {
			servicio.saveUsuario(usuario);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id")Long id) {
		
		servicio.deleteUsuario(id);
		
		return "redirect:/dashboard";
	}

}
