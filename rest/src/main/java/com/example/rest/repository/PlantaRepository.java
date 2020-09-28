package com.example.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Maceta;
import com.example.rest.model.Planta;


public interface PlantaRepository extends JpaRepository<Planta, Long> {
	
	List<Planta> findByMaceta(Maceta maceta);

}
