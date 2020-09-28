package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.model.Huerto;


public interface HuertoRepository extends JpaRepository<Huerto, Long> {

}
