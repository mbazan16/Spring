package com.sb.ln.interfaces;

import com.sb.entities.Region;
import com.sb.ln.exceptions.ServicioException;


public interface IServicioRegion {
	
	public Iterable<Region> mostrarRegiones() throws ServicioException;
	
}
