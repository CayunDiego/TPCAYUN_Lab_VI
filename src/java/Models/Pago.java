/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;
import java.time.LocalDateTime;


/**
 *
 * @author Diego
 */
public class Pago {
    private int idPago;
    private Float montoPago;
    private Date fecha;
    private Cliente cliente;

    public Pago() {
        cliente = new Cliente();
    }

    public Pago(int idPago, float montoPago, Date fecha, Cliente cliente) {
        this.idPago = idPago;
        this.montoPago = montoPago;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public float getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(float montoPago) {
        this.montoPago = montoPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
