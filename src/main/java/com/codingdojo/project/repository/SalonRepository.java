package com.codingdojo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.project.models.Salon;

@Repository
public interface SalonRepository  extends JpaRepository<Salon, Long>{
	
	

}
