package com.sb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sb.entities.Region;
import com.sb.ln.exceptions.ServicioException;
import com.sb.ln.interfaces.IServicioRegion;

@Controller
@RequestMapping("/region")
public class RegionController {
	
	private final static Logger log = LoggerFactory.getLogger(RegionController.class);

	@Autowired
	IServicioRegion servicio;
	
	@GetMapping
	public String xxx(Model model) throws ServicioException {
		log.info("[xxx]");
		
		conseguirListadoRegiones(model);
		
		return "regiones";
	}

	
	
	private void conseguirListadoRegiones(Model model) throws ServicioException {
		log.info("[conseguirListadoRegiones]");
		Iterable<Region> regiones= servicio.mostrarRegiones();		
		model.addAttribute("listado",regiones);
		log.debug("Regiones:"+regiones.toString());
	}
	
	

}
