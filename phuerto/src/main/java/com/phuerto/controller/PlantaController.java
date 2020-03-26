package com.phuerto.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phuerto.common.Categoria;
import com.phuerto.model.Maceta;
import com.phuerto.model.Planta;
import com.phuerto.repository.HuertoRepository;
import com.phuerto.repository.MacetaRepository;
import com.phuerto.repository.PlantaRepository;

@Controller
public class PlantaController {
	
	final static Logger logger = Logger.getLogger(PlantaController.class);
	
	@Autowired
	HuertoRepository huertoRepository;
	@Autowired
	MacetaRepository macetaRepository;
	@Autowired
	PlantaRepository plantaRepository;
	
	
	@RequestMapping("/planta")
	public String planta(Model model) {
		logger.info("Method [planta]");
		
		model.addAttribute("macetas", getMacetas());
		model.addAttribute("plantas", getPlantas());

		return "plantas";
	}
	
	
	@RequestMapping("/planta/ver")
	public String ver(@RequestParam Long id,Model model) {
		logger.info("Method [ver]");
		logger.debug("p[id]:"+id);
		
			Planta planta = plantaRepository.findOne(id);
			
			logger.debug("[planta]:"+planta);
			
			model.addAttribute("planta", planta);				
			model.addAttribute("macetas",getMacetas());
		
		return("planta");
	}
	
	@RequestMapping("/planta/modificarCategoria")
	public String editarCategoria(@RequestParam Categoria categoria,@RequestParam Long id,Model model) {
		logger.info("Method [editarCategoria]");
		logger.debug("p[categoria]:"+categoria);
		logger.debug("p[id]:"+id);
		
		
			Planta planta = plantaRepository.findOne(id);
			planta.setCategoria(categoria);
			plantaRepository.save(planta);
			
			logger.debug("[planta]:"+planta);
			
			model.addAttribute("planta", planta);			
			model.addAttribute("macetas", getMacetas());
			
		
		return("planta");
	}
	
	@RequestMapping("/planta/modificarMaceta")
	public String editarMaceta(@RequestParam Long idMaceta,@RequestParam Long id,Model model) {
		logger.info("Method [editarMaceta]");
		logger.debug("p[idMaceta]:"+idMaceta);		
		
			Maceta maceta = macetaRepository.findOne(idMaceta);
			logger.debug("[maceta]:"+maceta);
			
			Planta planta = plantaRepository.findOne(id);
			planta.setMaceta(maceta);
			plantaRepository.save(planta);
			
			logger.debug("[planta]:"+planta);
			
			model.addAttribute("planta", planta);			
			model.addAttribute("macetas", getMacetas());
			
		
		return("planta");
	}
	
	@RequestMapping(value="/planta/grabar" )
	public String crear( @RequestParam Categoria categoria,@RequestParam(name = "id") Long idMaceta, Model model) {
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

		model.addAttribute("macetas", getMacetas());
		model.addAttribute("plantas", getPlantas());

		return "plantas";
	}
	
	@RequestMapping(value="/planta/eliminar")
	public String grabar(@RequestParam Long id, Model model) {
		logger.info("Method [grabar]");
		logger.debug("p[id]:"+id);

		plantaRepository.delete(id);

		model.addAttribute("macetas", getMacetas());
		model.addAttribute("plantas", getPlantas());

		return "plantas";
	}
	
	private List<Maceta> getMacetas(){
		logger.info("Method private[getMacetas]");
		
		List<Maceta> macetas = macetaRepository.findAll();
		logger.debug("[macetas]");
		macetas.forEach(m ->logger.debug(m.toString()));
		return macetas;
	}
	
	private List<Planta> getPlantas(){
		logger.info("Method private[getPlantas]");
		
		List<Planta> plantas = plantaRepository.findAll();
		
		logger.debug("[plantas]");
		plantas.forEach(p ->logger.debug(p.toString()));
		return plantas;
	}
	
	
}
