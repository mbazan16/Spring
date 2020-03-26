package com.phuerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phuerto.model.Maceta;
import com.phuerto.model.Planta;


public interface PlantaRepository extends JpaRepository<Planta, Long> {
	
	List<Planta> findByMaceta(Maceta maceta);

}
