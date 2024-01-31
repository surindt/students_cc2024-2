package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto de un inventario
 * @author Kassandra Mirael
 */
public class ProductoInventario extends Producto{
    /** Disponibilidad. Cantidad de productos en el inventario */
    private int disponibilidad;

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /** Constructores */
    public ProductoInventario(String nombre, double costo) {
        super(nombre, costo);
    }

    public ProductoInventario(String string, double costo, int disponibilidad) {
        super(string, costo);
        this.disponibilidad = disponibilidad;
    }
}
