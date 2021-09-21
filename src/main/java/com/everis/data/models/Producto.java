package com.everis.data.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="productos")
public class Producto {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrementar
	private Long id;
	private String nombre;
	private String codigo;
	private String valor;
	private String stock;
	
	//relacion 1 a N (One to many)
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	private List<CarritoProducto> carritos_productos;
		
	
	/*
	//relacion n a m
	//JoinTable => name; joincolumn ; inverseJoinColumn
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="carritos_productos", joinColumns = @JoinColumn(name="producto_id") , inverseJoinColumns = @JoinColumn(name="carrito_id") )
	private List<Carrito> carritos;
		*/
	
	
	
	//Fechas
	@Column(updatable=false)
	@CreationTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@UpdateTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;


	public Producto() {
		super();
	}

	public Producto(String nombre, String codigo, String valor, String stock) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.valor = valor;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
/*
	public List<Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}
*/
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public List<CarritoProducto> getCarritos_productos() {
		return carritos_productos;
	}

	public void setCarritos_productos(List<CarritoProducto> carritos_productos) {
		this.carritos_productos = carritos_productos;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}

