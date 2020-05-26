package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.domain.Libro;
import com.uca.capas.domain.Categoria;
import com.uca.capas.service.LibroService;
import com.uca.capas.service.CategoriaService;

@Controller
public class MainController {

		
		@Autowired
		LibroService libroService;
		
		@Autowired
		CategoriaService categoriaService;
		
		@RequestMapping("/agregar")
		public ModelAndView agregar() {
			
			ModelAndView mav = new ModelAndView();
			List<Categoria> categorias = categoriaService.findAll();
			Libro libro = new Libro();
			
			mav.addObject("libro", libro);
			mav.addObject("categorias", categorias);
			mav.setViewName("insertar");
			
			return mav;
			
		}
		
		@RequestMapping("/agregarCat")
		public ModelAndView agregarCat() {
			
			ModelAndView mav = new ModelAndView();
			Categoria categoria = new Categoria();
			
			mav.addObject("categoria", categoria);
			mav.setViewName("insertarCat");
			
			return mav;
			
		}
		
		
		@RequestMapping("/index")
		public ModelAndView index() {
			
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("index");
			
			return mav;
			
		}
		@PostMapping("/guardar")
		public ModelAndView guardarCont(@Valid @ModelAttribute Libro c, BindingResult result) {
			
			ModelAndView mav = new ModelAndView();
	
			List<Categoria> categorias = categoriaService.findAll();

			if(result.hasErrors()) {
				mav.addObject("categorias", categorias);

				mav.setViewName("insertar");
			} else {
				
				String mensaje1 = "Libro guardado con éxito";
				mav.addObject("mensaje1", mensaje1);
				libroService.save(c);
				
				mav.setViewName("index");

			}
			
			return mav;
			
		}
		
		
		@PostMapping("/guardarCat")
		public ModelAndView guardarCat(@Valid @ModelAttribute Categoria cat, BindingResult result) {
			
			ModelAndView mav = new ModelAndView();
	

			if(result.hasErrors()) {

				mav.setViewName("insertarCat");
			} else {
				categoriaService.save(cat);
				
				String mensaje = "Categoría guardada con éxito";
				mav.addObject("mensaje", mensaje);
				mav.setViewName("index");

			}
			
			return mav;
			
		}
		
		@RequestMapping("/libros")
		public ModelAndView conts() {
			
			ModelAndView mav = new ModelAndView();
			List<Libro> libros = libroService.findAll();
			
			mav.addObject("libros", libros);
			mav.setViewName("main");
			
			return mav;
			
		}
	
	
}
