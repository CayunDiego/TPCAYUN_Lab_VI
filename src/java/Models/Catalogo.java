/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Catalogo {
    private int idCatalogo;
    private Date fechaIni;
    private Date fechaFin;
    private String descripcion;
    private ArrayList<DetalleCatalogo> detalles;

    public Catalogo() {
        detalles = new ArrayList<>();
    }

    public Catalogo(int idCatalogo, Date fechaIni, Date fechaFin, String descripcion, ArrayList<DetalleCatalogo> detalles) {
        this.idCatalogo = idCatalogo;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.detalles = detalles;
    }

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<DetalleCatalogo> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleCatalogo> detalles) {
        this.detalles = detalles;
    }

    
    
    
    
    
    
 
    
    
}
