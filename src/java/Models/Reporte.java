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
public class Reporte {
    private String nombre;
    private String apellido;
    private float saldo;
    private String estado;
    private float sumCompra;
    private float sumSaldo;
    private float sumPago;
    private float montoPago;
    private Date fecha;
    private String nomArticulo;
    private int cantVeces;
    private int cantVend;
    private int cantClient;

    public Reporte() {
    }

    public Reporte(String nombre, String apellido, float saldo, String estado, float sumCompra, float sumSaldo, float sumPago, float montoPago, Date fecha, String nomArticulo, int cantVeces, int cantVend, int cantClient) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
        this.estado = estado;
        this.sumCompra = sumCompra;
        this.sumSaldo = sumSaldo;
        this.sumPago = sumPago;
        this.montoPago = montoPago;
        this.fecha = fecha;
        this.nomArticulo = nomArticulo;
        this.cantVeces = cantVeces;
        this.cantVend = cantVend;
        this.cantClient = cantClient;
    }

    public float getSumCompra() {
        return sumCompra;
    }

    public void setSumCompra(float sumCompra) {
        this.sumCompra = sumCompra;
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getSumSaldo() {
        return sumSaldo;
    }

    public void setSumSaldo(float sumSaldo) {
        this.sumSaldo = sumSaldo;
    }

    public float getSumPago() {
        return sumPago;
    }

    public void setSumPago(float sumPago) {
        this.sumPago = sumPago;
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

    public String getNomArticulo() {
        return nomArticulo;
    }

    public void setNomArticulo(String nomArticulo) {
        this.nomArticulo = nomArticulo;
    }

    public int getCantVeces() {
        return cantVeces;
    }

    public void setCantVeces(int cantVeces) {
        this.cantVeces = cantVeces;
    }

    public int getCantVend() {
        return cantVend;
    }

    public void setCantVend(int cantVend) {
        this.cantVend = cantVend;
    }

    public int getCantClient() {
        return cantClient;
    }

    public void setCantClient(int cantClient) {
        this.cantClient = cantClient;
    }
    
    
}
