package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EditorialController {
	
	@Autowired
	private EditorialesRepository repositorioEditoriales;
	
	@RequestMapping("/nuevaEditorial")
	public String insertar(String nombre, String telefono, String email, String codigoPostal, String codIF,
						   Model model) {
		
		Editorial editorial = new Editorial(nombre, telefono, email, codigoPostal, codIF);
		repositorioEditoriales.save(editorial);

		return "nuevaEditorial";
	}
	
	@PostConstruct
	public void init()
	{
		repositorioEditoriales.save(new Editorial("El barco de vapor","918143526","elbarcodevapor@gmail.com","28609","dsajgdhsaj9"));
	}
}
