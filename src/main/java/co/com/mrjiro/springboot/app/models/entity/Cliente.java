/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.mrjiro.springboot.app.models.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author Martha Lopez
 */

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    /**
     * ATRIBUTOS
     */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @NotEmpty
    private String documento;

    @NotEmpty
    private String nombres;

    @NotEmpty
    private String apellidos;

    @NotEmpty
    private String telefono;

    @NotEmpty
    private String direccion;

    @Column(name = "create_At")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Cliente() {
        pedidos = new ArrayList<Pedido>();
    }

    public Cliente(Long idCliente, String tipoDocumento, String documento, String nombres, String apellidos, String direccion,
                   String telefono, Date createAt) {

        this.idCliente = idCliente;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.createAt = createAt;
    }

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedidos(Pedido pedido) {
        pedidos.add(pedido);
    }
}
