package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto
 * @author Kassandra Mirael
 */
public class Producto {
    protected String nombre;
    protected Double precio;

    public Producto(){
        this.nombre = "";
        this.precio = 0.;
    }

    public Producto(String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
}
