package com.phuerto.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phuerto.common.TipoMaceta;
import com.phuerto.model.Huerto;
import com.phuerto.model.Maceta;
import com.phuerto.model.Planta;
import com.phuerto.repository.HuertoRepository;
import com.phuerto.repository.MacetaRepository;
import com.phuerto.repository.PlantaRepository;

@Controller
public class MacetaController {
	
	final static Logger logger = Logger.getLogger(MacetaController.class);
	
	@Autowired
	HuertoRepository huertoRepository;
	@Autowired
	MacetaRepository macetaRepository;
	@Autowired
	PlantaRepository plantaRepository;
	
	
	@RequestMapping("/maceta")
	public String macetas(Model model) {
		logger.info("Method [macetas]");
		

		model.addAttribute("macetas", getMacetas());
		model.addAttribute("huertos", getHuertos());

		return "macetas";
	}
	
	
	@RequestMapping("/maceta/ver")
	public String ver(@RequestParam Long id,Model model) {
		logger.info("Method [ver]");
		logger.debug("p[id]:"+id);
		
		
			Maceta maceta = macetaRepository.findOne(id);
			logger.debug("[maceta]:"+maceta);
			
			model.addAttribute("maceta", maceta);			
			model.addAttribute("huertos", getHuertos());			
			model.addAttribute("plantas", getPlantasByMaceta(maceta));
		
		return("maceta");
	}
	
	@RequestMapping("/maceta/modificarTipo")
	public String editarTipo(@RequestParam TipoMaceta tipo,@RequestParam Long id,Model model) {
		logger.info("Method [editarTipo]");
		logger.debug("p[tipo]:"+tipo);
		logger.debug("p[id]:"+id);
		
		
			Maceta maceta = macetaRepository.findOne(id);
			maceta.setTipo(tipo);
			macetaRepository.save(maceta);
			
			logger.debug("[maceta]:"+maceta);
			
			model.addAttribute("maceta", maceta);			
			model.addAttribute("huertos", getHuertos());			
			model.addAttribute("plantas", getPlantasByMaceta(maceta));
			
		
		return("maceta");
	}
	
	@RequestMapping("/maceta/modificarHuerto")
	public String editarHuerto(@RequestParam Long idHuerto,@RequestParam Long id,Model model) {
		logger.info("Method [editarHuerto]");
		logger.debug("p[idHuerto]:"+idHuerto);
		logger.debug("p[id]:"+id);		
			
			Huerto huerto = huertoRepository.findOne(idHuerto);
			
			logger.debug("[huerto]:"+huerto);
			
			Maceta maceta = macetaRepository.findOne(id);
			maceta.setHuerto(huerto);
			macetaRepository.save(maceta);
			
			logger.debug("[maceta]:"+maceta);
			
			model.addAttribute("maceta", maceta);			
			model.addAttribute("huertos", getHuertos());			
			model.addAttribute("plantas", getPlantasByMaceta(maceta));
			
		
		return("maceta");
	}
	
	@RequestMapping(value="/maceta/grabar" )
	public String grabar( @RequestParam TipoMaceta tipo,@RequestParam(name = "id") Long idHuerto, Model model) {
		logger.info("Method [grabar]");
		logger.debug("p[tipo]:"+tipo);		
		logger.debug("p[idHuerto]:"+idHuerto);		

		Huerto huerto = huertoRepository.findOne(idHuerto);
		
		logger.debug("[huerto]:"+huerto);
		
		Maceta maceta = new Maceta();
		maceta.setHuerto(huerto);
		maceta.setTipo(tipo);
		macetaRepository.save(maceta);		

		model.addAttribute("macetas", macetaRepository.findAll());
		model.addAttribute("huertos", huertoRepository.findAll());

		return "macetas";
	}
	
	@RequestMapping(value="/maceta/eliminar")
	public String eliminar(@RequestParam Long id, Model model) {
		logger.info("Method [eliminar]");
		logger.debug("p[id]:"+id);

		macetaRepository.delete(id);

		model.addAttribute("macetas", macetaRepository.findAll());
		model.addAttribute("huertos", huertoRepository.findAll());

		return "macetas";
	}
	
	private List<Maceta> getMacetas(){
		logger.info("Method private[getMacetas]");
		
		List<Maceta> macetas = macetaRepository.findAll();
		logger.debug("[macetas]");
		macetas.forEach(m ->logger.debug(m.toString()));
		return macetas;
	}
	
	private List<Huerto> getHuertos(){
		logger.info("Method private[getHuertos]");
		
		List<Huerto> huertos = huertoRepository.findAll();
		
		logger.debug("[huertos]");
		huertos.forEach(h ->logger.debug(h.toString()));
		return huertos;
	}
	
	private List<Planta> getPlantasByMaceta(Maceta maceta){
		logger.info("Method private[getPlantasByMaceta]");
		
		List<Planta> plantas = plantaRepository.findByMaceta(maceta);
		logger.debug("[plantas]:");
		plantas.forEach(p ->logger.debug(p.toString()));
		return plantas;
	}
	
	
}
