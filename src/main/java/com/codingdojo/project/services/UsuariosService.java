package com.codingdojo.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.project.models.Hobby;
import com.codingdojo.project.models.Salon;
import com.codingdojo.project.models.Usuario;
import com.codingdojo.project.repository.HobbyRepository;
import com.codingdojo.project.repository.SalonRepository;
import com.codingdojo.project.repository.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Autowired 
	private SalonRepository repoSalones;
	
	@Autowired
	private HobbyRepository repoHobbies;
	
	//Regresa todos los usuarios
	public List<Usuario> findUsuarios(){
		return repoUsuarios.findAll();
	}
	
	//Regresar un usuario en base a su ID
	public Usuario findUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	//guardar un usuario
	public Usuario saveUsuario(Usuario nuevoUsuario) {
		return repoUsuarios.save(nuevoUsuario);
	}
	
	public void deleteUsuario(Long id) {
		repoUsuarios.deleteById(id);
	}
	
	//metodos de entidad salón
	
	public List<Salon> findSalones(){
		return repoSalones.findAll();
	}
	
	public Salon findSalon(Long id) {
		return repoSalones.findById(id).orElse(null);
	}
	
	
	public List<Usuario> findUsuariosSinSalon(){
		return repoUsuarios.findBySalonIdIsNull();
	}
	
	//metodos entidad Hobby
	
	public List<Hobby> findHobbies(){
		return repoHobbies.findAll();
	}
	
	public Hobby findHobbyById(Long id) {
		return repoHobbies.findById(id).orElse(null);
	}
	
	public void saveUsuarioHobby(Long user_id, Long hobby_id) {
		//obtengo el objeto del usuario al que queremos agregarle el hobby
		Usuario usuario = findUsuario(user_id);
		
		//obtener el hobby
		Hobby hobby = findHobbyById(hobby_id);
		
		
		//lista de hobbies 
		List<Hobby> listaHobbies = usuario.getHobbies();
		listaHobbies.add(hobby);
		
		repoUsuarios.save(usuario);
		
		
		/* List<Usuario> listaUsuarios = hobby.getUsuarios();
		 * listaUsuarios.add(usuarios)
		 * repoHobbies.save(hobby)
		 */
		 
	}
	
	//me regresa el listado de hobbies que un usuario en espeifico no tiene
	public List<Hobby> findHobbiesSinUsuario(Long user_id){
		
		Usuario usuario = findUsuario(user_id);
		
		return repoHobbies.findByUsuariosNotContains(usuario);
		
		
	}
	
	
	
	
	
	
}
