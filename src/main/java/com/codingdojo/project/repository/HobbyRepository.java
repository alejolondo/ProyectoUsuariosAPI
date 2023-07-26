package com.codingdojo.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.project.models.Hobby;
import com.codingdojo.project.models.Usuario;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {
	
	List<Hobby> findByUsuariosNotContains(Usuario usuario);
}
