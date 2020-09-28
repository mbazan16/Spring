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

import com.example.rest.common.Categoria;
import com.example.rest.model.Maceta;
import com.example.rest.model.Planta;
import com.example.rest.repository.HuertoRepository;
import com.example.rest.repository.MacetaRepository;
import com.example.rest.repository.PlantaRepository;

@RestController
@RequestMapping(value = "/planta", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlantaController {
	
	final static Logger logger = Logger.getLogger(PlantaController.class);
	
	@Autowired
	HuertoRepository huertoRepository;
	@Autowired
	MacetaRepository macetaRepository;
	@Autowired
	PlantaRepository plantaRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Planta> planta(Model model) {
		logger.info("Method [planta]");

		return getPlantas();
	}
	
	@RequestMapping("/maceta")
	public List<Planta> plantasByMaceta(@RequestParam Long id) {
		logger.info("Method [ver]");
		logger.debug("p[id]:"+id);
		
			Maceta maceta = macetaRepository.findOne(id);
			
			logger.debug("[maceta]:"+maceta);
			
			return getPlantasByMaceta(maceta);
	}
	
	
	@RequestMapping("/ver")
	public Planta ver(@RequestParam Long id) {
		logger.info("Method [ver]");
		logger.debug("p[id]:"+id);
		
			Planta planta = plantaRepository.findOne(id);
			
			logger.debug("[planta]:"+planta);
			
			return planta;
	}
	
	@RequestMapping("/planta/modificarCategoria")
	public void editarCategoria(@RequestParam Categoria categoria,@RequestParam Long id) {
		logger.info("Method [editarCategoria]");
		logger.debug("p[categoria]:"+categoria);
		logger.debug("p[id]:"+id);
		
		
			Planta planta = plantaRepository.findOne(id);
			planta.setCategoria(categoria);
			plantaRepository.save(planta);
			
			logger.debug("[planta]:"+planta);
	}
	
	@RequestMapping("/modificarMaceta")
	public void editarMaceta(@RequestParam Long idMaceta,@RequestParam Long id) {
		logger.info("Method [editarMaceta]");
		logger.debug("p[idMaceta]:"+idMaceta);		
		
			Maceta maceta = macetaRepository.findOne(idMaceta);
			logger.debug("[maceta]:"+maceta);
			
			Planta planta = plantaRepository.findOne(id);
			planta.setMaceta(maceta);
			plantaRepository.save(planta);
			
			logger.debug("[planta]:"+planta);
	}
	
	@RequestMapping(value="/grabar" )
	public void crear( @RequestParam Categoria categoria,@RequestParam(name = "id") Long idMaceta) {
		logger.info("Method [crear]");
		logger.debug("p[categoria]:"+categoria);
		logger.debug("p[idMaceta]:"+idMaceta);
		

		Maceta maceta = macetaRepository.findOne(idMaceta);
		logger.debug("[maceta]:"+maceta);
		
		Planta planta = new Planta();
		planta.setMaceta(maceta);
		planta.setCategoria(categoria);
		plantaRepository.save(planta);
		
		logger.debug("[planta]:"+planta);	
	}
	
	@RequestMapping(value="/eliminar")
	public void grabar(@RequestParam Long id) {
		logger.info("Method [grabar]");
		logger.debug("p[id]:"+id);

		plantaRepository.delete(id);
	}	
	
	
	private List<Planta> getPlantas(){
		logger.info("Method private[getPlantas]");
		
		List<Planta> plantas = plantaRepository.findAll();
		
		logger.debug("[plantas]");
		plantas.forEach(p ->logger.debug(p.toString()));
		return plantas;
	}
	

	
	private List<Planta> getPlantasByMaceta(Maceta maceta){
		logger.info("Method private[getPlantasByMaceta]");
		
		List<Planta> plantas = plantaRepository.findByMaceta(maceta);
		logger.debug("[plantas]:");
		plantas.forEach(p ->logger.debug(p.toString()));
		return plantas;
	}
	
	
}
