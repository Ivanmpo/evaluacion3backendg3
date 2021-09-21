package com.everis.data.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/adm/producto")
public class ProductoController {

	@Autowired
	private ProductoService ps;
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("producto") Producto producto, Model model) {
		model.addAttribute("lista_productos", ps.findAll());
		return "producto.jsp";
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public String insertar(@Valid @ModelAttribute("empleado") Producto producto) {
		ps.save(producto);
		return "redirect:/producto";
	}
	
	//Actualizar y modificar
	@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		Producto producto = ps.buscarProducto(id);
		model.addAttribute("producto", producto);
		return "editar_producto.jsp";
	}
	
	@RequestMapping(value="/modificar", method=RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("productp") Producto producto) {
		ps.modificarProducto(producto);
		return "redirect:/producto";
	}
	
	//Eliminar
	@RequestMapping(value="/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		ps.eliminarProducto(id);
		return "redirect:/producto";
	}
		
	
}
