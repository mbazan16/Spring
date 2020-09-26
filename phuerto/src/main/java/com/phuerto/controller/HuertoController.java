package com.phuerto.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phuerto.model.Huerto;
import com.phuerto.model.Maceta;
import com.phuerto.repository.HuertoRepository;
import com.phuerto.repository.MacetaRepository;

@Controller
public class HuertoController {
	
	final static Logger logger = Logger.getLogger(HuertoController.class);
	
	@Autowired
	HuertoRepository huertoRepository;
	@Autowired
	MacetaRepository macetaRepository;
	
	
	@RequestMapping("/")
	public String huertos(Model model) {
		logger.info("Method [huertos]");

		model.addAttribute("huertos", getHuertos());

		return "index";
	}

	
	
	@RequestMapping("/ver")
	public String ver(@RequestParam Long id,Model model) {
		logger.info("Method [ver]");
		logger.debug("p[id]:"+id);
		
		   
			Huerto huerto = huertoRepository.findOne(id);
			model.addAttribute("huerto", huerto);
			model.addAttribute("macetas", getMacetasByHuerto(huerto));
		
		return("huerto");
	}
	
	@RequestMapping(value="/grabar",method=RequestMethod.POST )
	public String grabar( Huerto huerto, Model model) {
		logger.info("Method [grabar]");
		logger.debug("p[huerto]:"+huerto);

		huertoRepository.save(huerto);
		
		logger.debug("[huerto]:"+huerto);

		model.addAttribute("huertos", getHuertos());

		return "index";
	}
	
	@RequestMapping(value="/crear")
	public String crear( @RequestParam String nombre, Model model) {
		logger.info("Method [crear]");
		logger.debug("p[nombre]:"+nombre);
		
		 Huerto huerto = new Huerto();
		 huerto.setNombre(nombre);

		huertoRepository.save(huerto);
		
		logger.debug("[huerto]:"+huerto);

		model.addAttribute("huertos", getHuertos());

		return "index";
	}
	@RequestMapping(value="/eliminar")
	public String eliminar( @RequestParam Long id, Model model) {
		logger.info("Method [eliminar]");
		logger.debug("p[id]:"+id);

		huertoRepository.delete(id);

		model.addAttribute("huertos", getHuertos());

		return "index";
	}
	
	private List<Huerto> getHuertos(){
		logger.info("Method private[getHuertos]");
		
		List<Huerto> huertos = huertoRepository.findAll();
		
		logger.debug("[huertos]");
		huertos.forEach(h ->logger.debug(h.toString()));
		return huertos;
	}
	
	private List<Maceta> getMacetasByHuerto(Huerto huerto){
		logger.info("Method private[getMacetasByHuerto]");
		
		List<Maceta> macetas = macetaRepository.findByHuerto(huerto);
		logger.debug("[macetas]:");		
		macetas.forEach(m ->logger.debug(m.toString()));
		return macetas;
	}
	
	
}
