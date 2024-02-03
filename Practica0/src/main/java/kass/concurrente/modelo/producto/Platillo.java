package kass.concurrente.modelo.producto;

import java.util.List;

/**
 * Clase que modela un platillo
 * @author Kassandra Mirael
 */
public class Platillo {
    /** Nombre del platillo */
    private String nombre;
    /** Cada platillo tiene tiempo de elaboración en minutos*/
    private int tiempoCoccion;
    /** Cada platillo tiene una lista de productos requeridos para su preparacion o como extra */
    private List<Producto> productosRequeridos;

    /** Precio */
    private Double precio = 0.;

    /** Constructor */
    public Platillo(){
        this.nombre = "";
        this.tiempoCoccion = 0;
    }

    /** Constructor */
    public Platillo(String nombre, int tiempo){
        this.nombre = nombre;
        this.tiempoCoccion = tiempo;
    }
    
    /** Constructor */
    public Platillo(List<Producto> productos, double precio, int tiempoCoccion, String string) {
        this.tiempoCoccion = tiempoCoccion;
        this.nombre = string;
        this.productosRequeridos = productos;
        this.precio = precio;
    }

    /* Getters y Setters */	
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public List<Producto> getProductosRequeridos() {
        return productosRequeridos;
    }

    public void setProductosRequeridos(List<Producto> productosRequeridos) {
        this.productosRequeridos = productosRequeridos;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Este metodo calcula el precio sobre el precio de los items, se ignora
     * el precio base.
     * @return El precio de la suma de cada item utilizado
     */
    public Double calculaPrecio(){
        Double suma = 0.;
        for(Producto p : this.productosRequeridos){
            suma += p.getPrecio();
        }
        return suma;
    }   
}
