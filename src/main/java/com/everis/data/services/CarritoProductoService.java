package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.data.models.Carrito;
import com.everis.data.models.CarritoProducto;
import com.everis.data.models.Producto;
import com.everis.data.repository.CarritoProductoRepository;
import com.everis.data.repository.CarritoRepository;
import com.everis.data.repository.ProductoRepository;

@Repository
public class CarritoProductoService  {

	@Autowired
	private CarritoProductoRepository cpr;
	
	public void save(CarritoProducto carritoProducto) {
		cpr.save(carritoProducto);
	}

	public void modificarCarritoProducto(@Valid CarritoProducto carritoProducto) {
		cpr.save(carritoProducto);
		
	}

	public void eliminarProductoCarro(Long id) {
		cpr.deleteById(id);
		
	}

	public CarritoProducto findById(Long id) {
		return cpr.getById(id);
		
	}
	
	public boolean ifExistById(Long id) {
	
		Optional<CarritoProducto> oCarritoProducto = cpr.findById(id);
		if(oCarritoProducto.isPresent()) {
			return true;
		}
		return false;
		
	}

	
}
