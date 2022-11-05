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

@Entity
@Table(name ="pedidosconproductos")
public class PedidosconProductos implements Serializable{
/**
 * 
 */
	private static final long serialVersionUID =1L;
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private  Long id;
	
	@NotNull
	private int id_pedido;
	
	@NotNull
	private int id_producto;
	
	@Column(name = "createAt")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	public PedidosconProductos () {
		
	}
	
	public PedidosconProductos (int id_pedido,int id_producto) {
		
		this.id_pedido =id_pedido;
		this.id_producto =id_producto;
		 this.createAt = createAt;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getId_pedido() {
		return id_pedido;
	}
	
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	public int getId_producto() {
		return id_producto;
	}
	
	public void setId_producto() {
		this.id_producto =id_producto;
	
	}
	
	@PrePersist
	public void prePersist() {
	 createAt = new Date();
	}
	
	
}
