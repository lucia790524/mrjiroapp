package co.com.mrjiro.springboot.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "pedidos_con_productos")
public class PedidosProducto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PedidosProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_pedido", insertable = false, updatable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public PedidosProducto() {
    }

    public PedidosProducto(PedidosProductoPK id, Integer cantidad, Double total, Boolean estado) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
    }

    public PedidosProductoPK getId() {
        return id;
    }

    public void setId(PedidosProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
