package com.everis.data.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Producto;
import com.everis.data.repository.ProductoRepository;

@Repository
public class ProductoService  {

	@Autowired
	private ProductoRepository pr;
	
	
	public List<Producto> findAll(){
		return pr.findAll();
	}
	
	public void save(Producto producto) {
		pr.save(producto);
	}

	public Producto buscarProducto(Long id) {
		Producto producto = pr.getById(id);
		return producto;
	}

	public void modificarProducto(@Valid Producto producto) {
		pr.save(producto);
		
	}

	public void eliminarProducto(Long id) {
		pr.deleteById(id);
		
	}
	
}
