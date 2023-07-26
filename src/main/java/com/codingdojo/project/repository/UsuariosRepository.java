package com.codingdojo.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.project.models.Usuario;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Long> {

	List<Usuario> findAll();
	
	
	List<Usuario> findByFirstName(String firstName);
	
	List<Usuario> findById(long id);
	
	Usuario save(Usuario nuevoUsuario);
	
	void deleteById(Long id);
	
	List<Usuario> findBySalonIdIsNull(); //SELECT * FROM usuarios WHERE classroom_id = 0
	
}
