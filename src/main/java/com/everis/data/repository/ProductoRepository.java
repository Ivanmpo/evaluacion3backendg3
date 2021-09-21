package com.everis.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.data.models.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
