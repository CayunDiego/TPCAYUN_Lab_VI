/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author Diego
 */
public class ActualizacionesImporte {
    private int idImporte;
    private Date fecha;
    private float porcentaje;
    private float saldo;
    private float salgoAct;
    private Cliente cliente;

    public ActualizacionesImporte() {
    }

    public ActualizacionesImporte(int idImporte, Date fecha, float porcentaje, float saldo, float salgoAct, Cliente cliente) {
        this.idImporte = idImporte;
        this.fecha = fecha;
        this.porcentaje = porcentaje;
        this.saldo = saldo;
        this.salgoAct = salgoAct;
        this.cliente = cliente;
    }

    public int getIdImporte() {
        return idImporte;
    }

    public void setIdImporte(int idImporte) {
        this.idImporte = idImporte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSalgoAct() {
        return salgoAct;
    }

    public void setSalgoAct(float salgoAct) {
        this.salgoAct = salgoAct;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
