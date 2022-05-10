 package com.sb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="REGIONS")
@NamedQuery(name ="Region.findAll",query = "SELECT r FROM Region r")
public class Region {

	@Id
	@Column(name="REGION_ID")
	private Integer id;
	@Column(name="REGION_NAME")
	private String nombre;
	
	

	public Region() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Region [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
   
}
