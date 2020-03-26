package com.phuerto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phuerto.model.Huerto;
import com.phuerto.model.Maceta;


public interface MacetaRepository extends JpaRepository<Maceta, Long> {
	
	List<Maceta> findByHuerto(Huerto huerto);

}
