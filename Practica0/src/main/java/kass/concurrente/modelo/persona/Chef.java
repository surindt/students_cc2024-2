package kass.concurrente.modelo.persona;
import java.util.List;

import kass.concurrente.modelo.cuchillo.Cuchillo;
import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;
import kass.concurrente.modelo.producto.ProductoInventario;

public class Chef extends Persona{
    /* Cuchillo */
   Cuchillo cuchillo;

    /* Constructor usando super*/
    public Chef(String nombre, Integer edad, Cuchillo cuchillo){
        super(nombre,edad);
        this.cuchillo = cuchillo;
    }

    /* Atender a cliente*/
    public List<ProductoInventario> atender(Persona cliente, List<ProductoInventario> inventario){
        System.out.println("Chef "+this.getNombre()+" Atendiendo a " + cliente.getNombre());

        // Preparando platillo. 
        // Revise que el chef tiene un cuchillo para preparar el platillo
        // Revisa que el inventario tenga los productos necesarios para preparar el platillo
        if(cliente.getOrden().size() > 0){
            System.out.println("Preparando platillo con cuchillo");
            int reduccion = this.cuchillo.corta();
            for (Platillo platillo : cliente.getOrden()) {
                // Verificar que el inventario tenga los productos necesarios
                for (Producto producto: platillo.getProductosRequeridos()) {
                    System.out.println("Buscando " + producto.getNombre() + " en el inventario");
                    ProductoInventario aux = inventario.stream().filter(p -> p.getNombre().equals(producto.getNombre())).findFirst().orElse(null);
                    if (aux == null) {
                        System.out.println("No se encontro " + producto.getNombre() + " en el inventario. Consiguiendo producto");
                        ProductoInventario nuevoProducto = new ProductoInventario(producto.getNombre(), 20);
                        inventario.add(nuevoProducto);
                    }else{
                        // Se encontro el producto en el inventario
                        aux.setDisponibilidad(aux.getDisponibilidad()-1);
                    }
                }
                long tiempoCoccion = platillo.getTiempoCoccion()-reduccion;
                // Dormir el tiempo de coccion
                if (tiempoCoccion > 0) {
                    System.out.println("Preparando " + platillo.getNombre() + " en " + tiempoCoccion + " minutos");
                    try {
                        Thread.sleep(tiempoCoccion * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Platillo " + platillo.getNombre() + " listo");
            }
        }
        return inventario;
    }
}
