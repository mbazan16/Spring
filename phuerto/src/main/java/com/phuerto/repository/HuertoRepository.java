package com.phuerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phuerto.model.Huerto;


public interface HuertoRepository extends JpaRepository<Huerto, Long> {

}
