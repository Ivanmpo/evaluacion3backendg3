package com.everis.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.data.models.Carrito;
import com.everis.data.models.CarritoProducto;



public interface CarritoProductoRepository extends JpaRepository<CarritoProducto, Long>{

}
