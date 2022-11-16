package co.com.mrjiro.springboot.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PedidosProductoPK implements Serializable {

    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(name = "id_producto")
    private Long idProducto;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
