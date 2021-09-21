package com.everis.data.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.everis.data.models.Carrito;
import com.everis.data.models.CarritoProducto;
import com.everis.data.models.Producto;
import com.everis.data.services.CarritoProductoService;
import com.everis.data.services.CarritoService;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	private CarritoService cs;
	@Autowired
	private ProductoService ps;
	@Autowired
	private CarritoProductoService cps;
	
	//Actualizar y modificar
	@RequestMapping(value="/{id_carrito}/agregar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id") Long id, Model model) {
		Producto producto = ps.buscarProducto(id);
		Carrito carrito = cs.findById(id_carrito);
		if(Integer.parseInt(producto.getStock()) >0) {
			producto.setStock( String.valueOf(Integer.parseInt(producto.getStock()) - 1 ) ) ;
			CarritoProducto cpto= new CarritoProducto();
			carrito.setValor_total(String.valueOf(Integer.parseInt(carrito.getValor_total()) + Integer.parseInt(producto.getValor())) );
			cpto.setCarrito(carrito);
			cpto.setProducto(producto);
			cs.modificarCarrito(carrito);
			cps.save(cpto);
		}else {
			//no hay stock
		}
		return "redirect:/tienda";
	}
	
	//Eliminar
	@RequestMapping(value="/eliminar/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") Long id) {
		CarritoProducto cpto = cps.findById(id);
		Producto producto = cpto.getProducto();
		producto.setStock( String.valueOf(Integer.parseInt(producto.getStock()) + 1 ) ) ;
		ps.modificarProducto(producto);
		Carrito carrito = cpto.getCarrito();
		carrito.setValor_total(String.valueOf(Integer.parseInt(carrito.getValor_total()) - Integer.parseInt(producto.getValor())) );
		cs.modificarCarrito(carrito);
		cps.eliminarProductoCarro(id);
		return "redirect:/tienda";
	}
		
		
		
}
