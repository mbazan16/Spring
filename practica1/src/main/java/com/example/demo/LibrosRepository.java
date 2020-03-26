package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LibrosRepository extends JpaRepository<Libro, Long>{

	List<Libro> findByTitulo(String titulo);
	List<Libro> findByAutor(String autor);
	List<Libro> findByCategoria(String categoria);
	List<Libro> findByPrecioVenta(double precioVenta);
	List<Libro> findByIsbn(int isbn);
	
	@Modifying @Transactional
	@Query("update Libro l set l.titulo = ?1 where l.isbn = ?2")
	void setTituloByIsbn(String titulo, int isbn);
	
	@Modifying @Transactional
	@Query("update Libro l set l.autor = ?1 where l.isbn = ?2")
	void setAutorByIsbn(String autor, int isbn);
	
	@Modifying @Transactional
	@Query("update Libro l set l.numPaginas = ?1 where l.isbn = ?2")
	void setNumPaginasByIsbn(int numPag, int isbn);
	
	@Modifying @Transactional
	@Query("update Libro l set l.precioVenta = ?1 where l.isbn = ?2")
	void setPrecioVentaByIsbn(double precio, int isbn);
	
	@Modifying @Transactional
	@Query("update Libro l set l.categoria = ?1 where l.isbn = ?2")
	void setCategoriaByIsbn(String categoria, int isbn);
	
	@Modifying @Transactional
	@Query("update Libro l set l.fecha = ?1 where l.isbn = ?2")
	void setFechaByIsbn(int fecha, int isbn);
	
	@Modifying @Transactional
	@Query("update Libro l set l.editorial = ?1 where l.isbn = ?2")
	void setEditorialByIsbn(Editorial e, int isbn);

}
	
	
