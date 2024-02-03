package kass.concurrente;

import java.util.ArrayList;
import java.util.List;

import kass.concurrente.modelo.cuchillo.CuchilloChef;
import kass.concurrente.modelo.persona.Chef;
import kass.concurrente.modelo.persona.Persona;
import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;
import kass.concurrente.modelo.producto.ProductoInventario;

/**
 * Clase Main
 * Aqui va toda tu simulacion
 * Genera un par de clientes para que los atienda el chef
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando simulacion");

        System.out.println("Creando inventario");
        List<ProductoInventario> inventario = new ArrayList<>();
        inventario.add(new ProductoInventario("Producto 1", 20));
        inventario.add(new ProductoInventario("Producto 2", 20));
        
        
        System.out.println("Creando platillo");
        // Crear productos
        Producto producto1 = new Producto("Producto 1", 20);
        Producto producto2 = new Producto("Producto 2", 20);
        Producto producto3 = new Producto("Producto 3", 20);

        // Crear platillos
        Platillo platillo = new Platillo("Platillo 1", 6);
        platillo.setProductosRequeridos(List.of(producto1,producto2));

        Platillo platillo2 = new Platillo("Platillo 2", 5);
        platillo2.setProductosRequeridos(List.of(producto2));

        Platillo platillo3 = new Platillo("Platillo 3", 7);
        platillo3.setProductosRequeridos(List.of(producto3));
        
        // Crear cuchillo
        CuchilloChef cuchillo = new CuchilloChef();
        // Crear un chef
        Chef chef = new Chef("Chef 1", 20,cuchillo);

        // Crear un par de clientes
        Persona cliente1 = new Persona("Cliente 1",20);
        Persona cliente2 = new Persona("Cliente 2",30);
        Persona cliente3 = new Persona("Cliente 3",23);

        // Cliente 1 ordena
        cliente1.ordenar(platillo);
        inventario = chef.atender(cliente1,inventario);

        // Cliente 2 ordena
        cliente2.ordenar(producto3);

        // chef atiende a cliente 2
        inventario = chef.atender(cliente2,inventario);

        // Cliente 3 ordena
        cliente3.ordenar(platillo3);
        inventario = chef.atender(cliente3,inventario);
    }
}