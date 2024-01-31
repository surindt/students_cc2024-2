package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto
 * @author Kassandra Mirael
 */
public class Producto {
    /** Nombre del producto */
    private String nombre;
    /** Costo del producto */
    private Double precio;

    /* Constructores */
    public Producto(){
        this.nombre = "";
        this.precio = 0.;
    }

    public Producto(Double costo){
        this.precio = costo;
    }

    public Producto(String string, double d) {
        this.nombre = string;
        this.precio = d;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
