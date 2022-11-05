/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.mrjiro.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lopez
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String descripcion;

	@NotEmpty
	private String nombre;

	@NotNull
	private int precio;

	@Column(name = "createAt")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@NotNull
	private int id_proveedores;

	@NotNull
	private int id_tipo_producto;

	@NotNull
	private int inventario;

	public Producto() {

	}

	public Producto(String clase, String nombre, int precio, Date fechaVencimiento) {

		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.createAt = createAt;
		this.id_proveedores = id_proveedores;
		this.id_tipo_producto = id_tipo_producto;
		this.inventario = inventario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setClase(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public int getId_proveedores() {
		return id_proveedores;
	}

	public void setId_proveedores(int id_proveedores) {
		this.id_proveedores = id_proveedores;
	}

	public int getId_tipo_producto() {
		return id_tipo_producto;
	}

	public void setId_tipo_producto(int id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}
}
