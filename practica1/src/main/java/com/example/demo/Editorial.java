package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Editorial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombre;
	private String telefono;
	private String email;
	private String codigoPostal;
	private String codIF;
	
	@OneToMany(mappedBy = "editorial")
	private List<Libro> libros;
	
	public Editorial()
	{
		
	}
	
	public Editorial(String nombre, String tel, String correo, String cp, String cif)
	{
		this.nombre = nombre;
		this.telefono = tel;
		this.email = correo;
		this.codigoPostal = cp;
		this.codIF = cif;
	}
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCodIF() {
		return codIF;
	}
	public void setCodIF(String codIF) {
		this.codIF = codIF;
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
