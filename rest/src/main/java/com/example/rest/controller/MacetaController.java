package com.example.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.common.TipoMaceta;
import com.example.rest.model.Huerto;
import com.example.rest.model.Maceta;
import com.example.rest.repository.HuertoRepository;
import com.example.rest.repository.MacetaRepository;
import com.example.rest.repository.PlantaRepository;

@RestController
@RequestMapping(value = "/maceta", produces = MediaType.APPLICATION_JSON_VALUE)
public class MacetaController {
	
	final static Logger logger = Logger.getLogger(MacetaController.class);
	
	@Autowired
	HuertoRepository huertoRepository;
	@Autowired
	MacetaRepository macetaRepository;
	@Autowired
	PlantaRepository plantaRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Maceta> macetas(Model model) {
		logger.info("Method [macetas]");
		

		return getMacetas();
	}
	
	@RequestMapping("/huerto")
	public List<Maceta> macetasByHuerto(@RequestParam Long id) {
		logger.info("Method [ver]");
		logger.debug("p[id]:"+id);
		
		
			Huerto huerto = huertoRepository.findOne(id);
			logger.debug("[huerto]:"+huerto);
			
			return getMacetasByHuerto(huerto);
	}
	
	
	@RequestMapping("/ver")
	public Maceta ver(@RequestParam Long id) {
		logger.info("Method [ver]");
		logger.debug("p[id]:"+id);
		
		
			Maceta maceta = macetaRepository.findOne(id);
			logger.debug("[maceta]:"+maceta);
			
			return maceta;
	}
	
	@RequestMapping("/modificarTipo")
	public void editarTipo(@RequestParam TipoMaceta tipo,@RequestParam Long id) {
		logger.info("Method [editarTipo]");
		logger.debug("p[tipo]:"+tipo);
		logger.debug("p[id]:"+id);
		
		
			Maceta maceta = macetaRepository.findOne(id);
			maceta.setTipo(tipo);
			macetaRepository.save(maceta);
			
			logger.debug("[maceta]:"+maceta);
			
			
	}
	
	@RequestMapping("/modificarHuerto")
	public void editarHuerto(@RequestParam Long idHuerto,@RequestParam Long id) {
		logger.info("Method [editarHuerto]");
		logger.debug("p[idHuerto]:"+idHuerto);
		logger.debug("p[id]:"+id);		
			
			Huerto huerto = huertoRepository.findOne(idHuerto);
			
			logger.debug("[huerto]:"+huerto);
			
			Maceta maceta = macetaRepository.findOne(id);
			maceta.setHuerto(huerto);
			macetaRepository.save(maceta);
			
			logger.debug("[maceta]:"+maceta);
	}
	
	@RequestMapping(value="/grabar" )
	public void grabar( @RequestParam TipoMaceta tipo,@RequestParam(name = "id") Long idHuerto) {
		logger.info("Method [grabar]");
		logger.debug("p[tipo]:"+tipo);		
		logger.debug("p[idHuerto]:"+idHuerto);		

		Huerto huerto = huertoRepository.findOne(idHuerto);
		
		logger.debug("[huerto]:"+huerto);
		
		Maceta maceta = new Maceta();
		maceta.setHuerto(huerto);
		maceta.setTipo(tipo);
		macetaRepository.save(maceta);	
	}
	
	@RequestMapping(value="/eliminar")
	public void eliminar(@RequestParam Long id) {
		logger.info("Method [eliminar]");
		logger.debug("p[id]:"+id);

		macetaRepository.delete(id);
	}
	
	private List<Maceta> getMacetas(){
		logger.info("Method private[getMacetas]");
		
		List<Maceta> macetas = macetaRepository.findAll();
		logger.debug("[macetas]");
		macetas.forEach(m ->logger.debug(m.toString()));
		return macetas;
	}
	
	private List<Maceta> getMacetasByHuerto(Huerto huerto){
		logger.info("Method private[getMacetasByHuerto]");
		
		List<Maceta> macetas = macetaRepository.findByHuerto(huerto);
		logger.debug("[macetas]:");		
		macetas.forEach(m ->logger.debug(m.toString()));
		return macetas;
	}
	
	
	
	
}
