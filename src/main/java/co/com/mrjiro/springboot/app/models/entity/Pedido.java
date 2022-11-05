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
@Table(name="pedido")
public class Pedido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="createAt")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@NotNull
	private int precio;
	
	@NotEmpty
	private String estado;
	
	@NotNull
	private int id_cliente;
	
	@NotNull
	private int id_factura;
	
	
	
    public Pedido(){
        
    }

    public Pedido(Date createAt, int precio,String estado,int id_cliente,int id_factura) {
    	
        this.createAt = createAt;
        this.precio = precio;
        this.estado = estado;
        this.id_cliente= id_cliente;
        this.id_factura = id_factura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     
    @PrePersist
    public void prePersist() {
    	createAt = new Date();
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getId_factura() {
    	return id_factura;
    }
    public void setId_factura(int id_factura) {
    	this.id_factura =id_factura;
    }
}
