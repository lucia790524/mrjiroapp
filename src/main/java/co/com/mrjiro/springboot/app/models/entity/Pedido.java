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
public class Pedido {
    int orden; 
    int factura;
    int cantidad;
    Date fecha;
    String cliente;
    
    public Pedido (){
        
    }

    public Pedido(int orden, int factura, int cantidad, Date fecha, String cliente) {
        this.orden = orden;
        this.factura = factura;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
