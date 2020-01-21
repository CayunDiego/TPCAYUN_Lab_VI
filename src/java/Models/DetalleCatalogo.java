/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Diego
 */
public class DetalleCatalogo {
    private int idDetalleCat;
    private Articulo articulo;

    public DetalleCatalogo() {
        articulo = new Articulo();
    }

    public DetalleCatalogo(int idDetalleCat, Articulo articulo) {
        this.idDetalleCat = idDetalleCat;
        this.articulo = articulo;
    }

    public int getIdDetalleCat() {
        return idDetalleCat;
    }

    public void setIdDetalleCat(int idDetalleCat) {
        this.idDetalleCat = idDetalleCat;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    
}
