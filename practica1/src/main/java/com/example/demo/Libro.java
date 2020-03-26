package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Editorial editorial;
	
	
	private String autor;
	private String titulo;
	private int numPaginas;
	private int isbn;
	private double precioVenta;
	private String categoria;
	private int fecha;
	
	public Libro() {
		
	}
	
	public Libro(String autores, String titulo, Editorial editorial, int fecha, int numPaginas, int isbn, double d, String categoria) {
		this.autor = autores;
		this.titulo = titulo;
		this.editorial = editorial;
		this.fecha = fecha;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.precioVenta = d;
		this.categoria = categoria;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
}
