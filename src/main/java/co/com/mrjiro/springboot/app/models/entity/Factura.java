/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.mrjiro.springboot.app.models.entity;

import java.util.Date;

/**
 *
 * @author lopez
 */
public class Factura {
    int id_factura;
    int pedido_orden;
    int id_orden;
    int id_producto;
    Date fecha;
    
    public Factura (){
        
    }

    public Factura(int id_factura, int pedido_orden, int id_orden, int id_producto, Date fecha) {
        this.id_factura = id_factura;
        this.pedido_orden = pedido_orden;
        this.id_orden = id_orden;
        this.id_producto = id_producto;
        this.fecha = fecha;
    }
    

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getPedido_orden() {
        return pedido_orden;
    }

    public void setPedido_orden(int pedido_orden) {
        this.pedido_orden = pedido_orden;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
 
    
}
