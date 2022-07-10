package com.idat.MayoServicioPrueba.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos_clientes")
public class ProductoCliente {
	
	@Id
	private ProductoClientePK fk = new ProductoClientePK();
	
	private Integer cantidad;

	public ProductoClientePK getFk() {
		return fk;
	}

	public void setFk(ProductoClientePK fk) {
		this.fk = fk;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}

@Embeddable
class ProductoClientePK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_producto", nullable = false, unique = true)
	private Integer idProducto;
	
	@Column(name = "id_cliente", nullable = false, unique = true)
	private Integer idCliente;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
}
