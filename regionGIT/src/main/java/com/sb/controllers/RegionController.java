package com.sb.controllers;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@PostMapping("/n")
	public String nuevo(Model model,@RequestParam String nombre, HttpSession session) throws ServicioException {
		log.info("[nuevo]");
		
		
		
		servicio.crearRegion(nombre);
		conseguirListadoRegiones(model);
		
		log.debug("Se ha creado la region");
		
		//Mandamos mensaje al jsp
		
		ResourceBundle rb=ResourceBundle.getBundle("message");
		String idioma = (String) session.getAttribute("locale");
		
		if("en_US".equals(idioma)) {
			rb = ResourceBundle.getBundle("message",Locale.US);
		}		
		
		String message=rb.getString("region.crear");
		
		log.debug("Mensaje:"+message);
		
		model.addAttribute("message", message);
		
		return "regiones";
	}
	
	
	private void conseguirListadoRegiones(Model model) throws ServicioException {
		log.info("[conseguirListadoRegiones]");
		Iterable<Region> regiones= servicio.mostrarRegiones();		
		model.addAttribute("listado",regiones);
		log.debug("Regiones:"+regiones.toString());
	}
	
	

}
