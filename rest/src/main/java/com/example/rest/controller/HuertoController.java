package com.example.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.Huerto;
import com.example.rest.repository.HuertoRepository;
import com.example.rest.repository.MacetaRepository;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HuertoController {
	
	final static Logger logger = Logger.getLogger(HuertoController.class);
	
	@Autowired
	HuertoRepository huertoRepository;
	@Autowired
	MacetaRepository macetaRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Huerto> huertos() {
		logger.info("Method [huertos]");
		return getHuertos();
	}

	
	
	@RequestMapping("/ver")
	public Huerto ver(@RequestParam Long id) {
		logger.info("Method [ver]");
		logger.debug("p[id]:"+id);
		
		   
			return huertoRepository.findOne(id);
	}
	
	@RequestMapping(value="/grabar")
	public void grabar(@RequestBody @Valid Huerto huerto) {
		logger.info("Method [grabar]");
		logger.debug("p[huerto]:"+huerto);

		huertoRepository.save(huerto);
		
		logger.debug("[huerto]:"+huerto);
	}
	
	@RequestMapping(value="/crear")
	public void crear( @RequestParam String nombre) {
		logger.info("Method [crear]");
		logger.debug("p[nombre]:"+nombre);
		
		 Huerto huerto = new Huerto();
		 huerto.setNombre(nombre);

		huertoRepository.save(huerto);
		
		logger.debug("[huerto]:"+huerto);
	}
	@RequestMapping(value="/eliminar")
	public void eliminar( @RequestParam Long id) {
		logger.info("Method [eliminar]");
		logger.debug("p[id]:"+id);

		huertoRepository.delete(id);
	}
	
	private List<Huerto> getHuertos(){
		logger.info("Method private[getHuertos]");
		
		List<Huerto> huertos = huertoRepository.findAll();
		
		logger.debug("[huertos]");
		huertos.forEach(h ->logger.debug(h.toString()));
		return huertos;
	}
	
	
	
	
}
