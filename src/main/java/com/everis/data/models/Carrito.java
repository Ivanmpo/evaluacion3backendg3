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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="carritos")
public class Carrito {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrementar
	private Long id;
	private String codigo;
	private String valor_total;
	

	//Relacion 1 a n
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	//relacion 1 a N (One to many)
	@OneToMany(mappedBy = "carrito", fetch = FetchType.LAZY)
	private List<CarritoProducto> carritos_productos;
		
		
	/*
	//relacion n a n
	//tabla intermedia
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="carritos_productos", joinColumns = @JoinColumn(name="carrito_id") , inverseJoinColumns = @JoinColumn(name="producto_id")  )
	private List<Producto> productos;
	*/
	
	//Fechas
	@Column(updatable=false)
	@CreationTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@UpdateTimestamp
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;


	public Carrito() {
		super();
	}

	public Carrito(String codigo, String valor_total) {
		super();
		this.codigo = codigo;
		this.valor_total = valor_total;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor_total() {
		return valor_total;
	}

	public void setValor_total(String valor_total) {
		this.valor_total = valor_total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	public List<CarritoProducto> getCarritos_productos() {
		return carritos_productos;
	}

	public void setCarritos_productos(List<CarritoProducto> carritos_productos) {
		this.carritos_productos = carritos_productos;
	}

	/*
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
*/
	public Date getCreatedAt() {
		return createdAt;
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

