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
/**
 *
 * @author lopez
 */
@Entity
@Table(name="factura")
public class Factura implements Serializable {
    /**
     * 
     */
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String tipo_pago;
	
	@NotEmpty
	private String estado;
	
	@Column(name = "createAt")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
    public Factura (){
        
    }

    public Factura(String tipo_pago, String estado,Date createAt) {
    	
        this.tipo_pago = tipo_pago;
        this.estado = estado;
        this.createAt= createAt;
        
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @PrePersist
	public void prePersist() {
	 createAt = new Date();
	}

}
 
    

