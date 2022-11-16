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



@Entity
@Table(name="categorias")
public class Categoria implements Serializable{
/**
 * 
 */
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private String estado;
	 
	@Column(name = "createAt")
	@Temporal(TemporalType.DATE)
	private Date  createAt;
	
	public Categoria () {
		
	}
	
	public Categoria (String nombre, String descripcion, String estado,Date  createAt) {
		
		this.nombre =nombre;
		this.descripcion=descripcion;
		this.estado =estado;
		this.createAt =createAt;
	}
	
	public Long getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String  getNombre() {
		return nombre;
	}
	
	public void  setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	 public  String getDescripcion (){
		 return descripcion;
	 }
	 
	 public void  setDescripcion(String descripcion) {
		 this.descripcion =descripcion;
	 }
	 public String getEstado() {
		 return estado;
	 }
	 
	 public void  setEstado (String estado) {
		 this.estado =estado;
		 
	 }
	 @PrePersist
		public void prePersist() {
		 createAt = new Date();
		}
}
