package co.com.mrjiro.springboot.app.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author lopez
 */
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createAt")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @NotNull
    private int precio;

    @NotEmpty
    private String estado;

    @OneToMany(mappedBy = "producto")
    private List<PedidosProducto> productos;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_factura", insertable = false, updatable = false)
    private Factura factura;

    public Pedido() {
    }

    public Pedido(Date createAt, int precio, String estado, int id_cliente, int id_factura) {

        this.createAt = createAt;
        this.precio = precio;
        this.estado = estado;
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
}
