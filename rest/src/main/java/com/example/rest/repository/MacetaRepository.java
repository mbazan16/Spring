package com.example.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Huerto;
import com.example.rest.model.Maceta;


public interface MacetaRepository extends JpaRepository<Maceta, Long> {
	
	List<Maceta> findByHuerto(Huerto huerto);

}
