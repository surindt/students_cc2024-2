package kass.concurrente.modelo.persona;

import java.util.ArrayList;
import java.util.List;

import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;

/**
 * Clase que modela una persona
 * @author Kassandra Mirael
 */
public class Persona {
    /** Nombre de la persona */
    private String nombre;
    /** Edad de la persona */
    private Integer edad;

    /** Pedidos de la persona */
    private List<Platillo> orden;

    public List<Platillo> getOrden() {
        return orden;
    }

    public void setOrden(List<Platillo> orden) {
        this.orden = orden;
    }

    public Persona(String nombre, Integer edad){
        this.nombre = nombre;
        this.edad = edad;
        this.orden = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /** Ordenar un platillo */
	public void ordenar(Platillo platillo) {
		System.out.println( this.nombre + " ordena " + platillo.getNombre());
        this.orden.add(platillo);
	}
    /** Ordenar un producto */
    public void ordenar(Producto producto) {
        System.out.println(this.nombre + " ordena " + producto.getNombre());
        this.orden.add(new Platillo(List.of(producto), producto.getPrecio(), 0, producto.getNombre()));
    }

    /** Tenemos una lista de platillos*/
    public void ordenar(List<Platillo> platillos) {
        System.out.println(this.nombre + " ordena " + platillos);
        for (Platillo platillo : platillos) {
            this.orden.add(platillo);
        }
    }
}
