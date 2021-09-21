package com.everis.data.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Carrito;
import com.everis.data.models.Producto;
import com.everis.data.repository.CarritoRepository;
import com.everis.data.repository.ProductoRepository;

@Repository
public class CarritoService  {

	@Autowired
	private CarritoRepository cr;
	
	public void save(Carrito carrito) {
		cr.save(carrito);
	}

	public void modificarCarrito(@Valid Carrito carrito) {
		cr.save(carrito);
		
	}

	public Carrito findById(Long id_carrito) {
		
		return cr.getById(id_carrito);
	}
	
}
