package com.phuerto.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.phuerto.common.Categoria;

@Entity
public class Planta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@ManyToOne
	private Maceta maceta;

	public Planta() {
		super();
	}

	public Planta(Categoria categoria) {
		super();
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Maceta getMaceta() {
		return maceta;
	}

	public void setMaceta(Maceta maceta) {
		this.maceta = maceta;
	}

	@Override
	public String toString() {
		return "Planta [id=" + id + ", categoria=" + categoria + ", maceta=" + maceta + "]";
	}

	
	
	
}
