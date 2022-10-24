package co.com.mrjiro.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "tipo_documento")
	private String tipoDocumento; 
	
	@NotEmpty
	private String documento;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;

	@NotEmpty
	private String direccion;

	@NotEmpty
	private String telefono;
	
	public Proveedor() {
		
	}
	
	public Proveedor(String tipoDocumento, String documento, String nombre, String apellido, String direccion,
			String telefono,String nombreproducto,String clase,int precio){
		
		
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}


