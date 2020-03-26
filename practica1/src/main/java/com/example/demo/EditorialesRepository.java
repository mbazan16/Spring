package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface EditorialesRepository extends JpaRepository<Editorial, Long>{

	Editorial findByNombre(String nombre);
	List<Editorial> findAllByOrderByNombreAsc();
	
	@Modifying @Transactional
	@Query("update Editorial e set e.nombre = ?1 where e.codIF = ?2")
	void setNombreByCodIF(String nombre, String string);
	
	@Modifying @Transactional
	@Query("update Editorial e set e.telefono = ?1 where e.codIF = ?2")
	void setTelefonoByCodIF(String string, String string2);
	
	@Modifying @Transactional
	@Query("update Editorial e set e.email = ?1 where e.codIF = ?2")
	void setEmailByCodIF(String email, String string);
	
	@Modifying @Transactional
	@Query("update Editorial e set e.codigoPostal = ?1 where e.codIF = ?2")
	void setCodigoPostalByCodIF(String string, String string2);
	
}
