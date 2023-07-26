package com.codingdojo.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.project.models.Usuario;
import com.codingdojo.project.services.UsuariosService;

@RestController
@RequestMapping("/api")
public class UsuariosAPIController {

	@Autowired
	private UsuariosService servicio;

	@GetMapping("/usuarios")
	public List<Usuario> muestraUsuarios() {
		return servicio.findUsuarios();
	}

	@PostMapping("/usuarios")
	public Usuario crearUsuario(@RequestParam("firstName") String fistName, @RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("password") String password) {
		Usuario nuevoUsuario = new Usuario(fistName, lastName, email, password);

		return servicio.saveUsuario(nuevoUsuario);

	}

	@GetMapping("/usuarios/{id}")
	public Usuario muestraUsuario(@PathVariable("id") Long id) {
		return servicio.findUsuario(id);
	}

	@DeleteMapping("/usuarios/{id}")
	public void borrar(@PathVariable("id") Long id) {
		servicio.deleteUsuario(id);
	}

	@PutMapping("/usuarios/{id}")
	public Usuario actualizar(@PathVariable("id") long id, @RequestParam("firstName") String fistName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
			@RequestParam("password") String password) {

		Usuario usuarioActualizado = new Usuario(id, fistName, lastName, email, password);
		return servicio.saveUsuario(usuarioActualizado);

	}
	
	@GetMapping("/usuarios2")
	public ResponseEntity<List<Usuario>> muestraUsuarios2(){
		
		List<Usuario> usuarios = servicio.findUsuarios();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	
	@PostMapping("/usuario/nuevo")
	public ResponseEntity<Usuario> nuevoUsuario(@RequestBody Usuario nuevoUsuario){
		
		servicio.saveUsuario(nuevoUsuario);
		
		return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
	}
}
