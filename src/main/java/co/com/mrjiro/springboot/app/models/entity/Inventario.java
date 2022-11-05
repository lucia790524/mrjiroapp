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
import javax.validation.constraints.NotNull;

/**
 *
 * @author lopez
 */  
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {
     /**
      * 
      */
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int cantidad;
	
	@Column(name = "createAt")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Column(name = "updateAt")
	@Temporal(TemporalType.DATE)
	private Date updateAt;
    

    public Inventario(int cantidad, Date createAt, Date updateAt) {
    	
        this.cantidad = cantidad;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @PrePersist
	public void PrePersist() {
	 createAt = new Date();
	}

    
}
