package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LibroController {
	@Autowired
	private LibrosRepository repositorioLibros;
	@Autowired
	private EditorialesRepository repositorioEditoriales;
	
	@RequestMapping("/")
	public String tablon(Model model) {

		model.addAttribute("libros", repositorioLibros.findAll());

		return "index";
	}
	
	@RequestMapping("/nuevoLibro")
	public String insertar(Model model) {
		
		List<Editorial> editoriales =repositorioEditoriales.findAllByOrderByNombreAsc();
		
		model.addAttribute("editoriales", editoriales);
		
		return("nuevoLibro");
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam String nombre, Libro libro, Model model) {

		Editorial e = repositorioEditoriales.findByNombre(nombre);
		libro.setEditorial(e);

		repositorioLibros.save(libro);
		
		e.getLibros().add(libro);		
		repositorioEditoriales.save(e);

		return "insertar";
	}
	
	@RequestMapping("/mostrarPorTitulo")
	public String mostrarPorAsunto(@RequestParam String titulo, Model model) {

		List<Libro> libros = repositorioLibros.findByTitulo(titulo);

	    model.addAttribute("libros", libros);

		return "mostrar";
	}
	
	@RequestMapping("/mostrarPorAutor")
	public String mostrarPorTitulo(@RequestParam String autor, Model model) {

		List<Libro> libros = repositorioLibros.findByAutor(autor);

	    model.addAttribute("libros", libros);

		return "mostrar";
	}
	
	@RequestMapping("/mostrarPorCategoria")
	public String mostrarPorCategoria(@RequestParam String categoria, Model model) {

		List<Libro> libros = repositorioLibros.findByCategoria(categoria);

	    model.addAttribute("libros", libros);

		return "mostrar";                                 
	}
	
	@RequestMapping("/mostrarPorPrecio")
	public String mostrarPorPrecio(@RequestParam String precio, Model model) {

		double pre = Double.parseDouble(precio);
		
		List<Libro> libros = repositorioLibros.findByPrecioVenta(pre);

		model.addAttribute("libros", libros);

		return "mostrar";
	}
	
	@RequestMapping("/mostrarPorEditorial")
	public String mostrarPorEditorial(@RequestParam String nombre, Model model) {

		Editorial e = repositorioEditoriales.findByNombre(nombre);

    	model.addAttribute("libros", e.getLibros());

		return "mostrar";
	}
	
	@RequestMapping("/mostrarPorIsbn")
	public String mostrarPorIsbn(@RequestParam String isbn, Model model) {

		int i = Integer.parseInt(isbn);

		List<Libro> libros = repositorioLibros.findByIsbn(i);

		model.addAttribute("libros", libros);

		return "mostrar";
	}
	
	@RequestMapping("/mostrarEditorial")
	public String mostrarEditorial(@RequestParam String nombre, Model model) {

		Editorial e = repositorioEditoriales.findByNombre(nombre);

    	model.addAttribute("libros", e.getLibros());

		return "mostrarEditorial";
	}
	
	
	
	@PostConstruct
	public void init()
	{
		Editorial e = repositorioEditoriales.findByNombre("El barco de vapor");
		repositorioLibros.save(new Libro("Juan","Si o no",e,2017,192,123456456,20.99,"Ciencia"));
	}
}
