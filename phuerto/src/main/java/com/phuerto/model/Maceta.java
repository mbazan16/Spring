package com.phuerto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.phuerto.common.TipoMaceta;

@Entity
public class Maceta {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="tipo")
	private TipoMaceta tipo;
	
	@ManyToOne
	private Huerto huerto;

	public Maceta() {
		super();
	}	

	public Maceta(TipoMaceta tipo) {
		super();
		this.tipo = tipo;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public TipoMaceta getTipo() {
		return tipo;
	}



	public void setTipo(TipoMaceta tipo) {
		this.tipo = tipo;
	}



	public Huerto getHuerto() {
		return huerto;
	}


	public void setHuerto(Huerto huerto) {
		this.huerto = huerto;
	}


	@Override
	public String toString() {
		return "Maceta [id=" + id + ", tipo=" + tipo + ", huerto=" + huerto + "]";
	}
	
	
	
	
	
}
