package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlatilloTest {
    Platillo p1, p2, p3;
    List<Producto> productos;
    
    @BeforeEach
    void setUp(){
        p1 = new Platillo();
        p2 = new Platillo("Test",10);
        productos = new ArrayList<>();
        annadeProductos();
        p3 = new Platillo(productos,10.,10,"Test3");
    }

    void annadeProductos(){
        productos.add(new Producto("Producto 1",5.));
        productos.add(new Producto("Producto 2",6.));
        productos.add(new Producto("Producto 3",7.));
    }

    @Test
    void constructorTest1(){
        assertNotNull(p1);
    }

    @Test
    void constructorTest2(){
        assertTrue(p2.getNombre().equals("Test")&&p2.getTiempoCoccion()==10);
    }

    @Test
    void constructorTest3(){
        assertTrue(p3.getNombre().equals("Test3")&&p3.getTiempoCoccion()==10&&p3.getProductosRequeridos().size() == 3);
    }

    @Test
    void calculaPrecio(){
        assertEquals(18., p3.calculaPrecio());
    }
}
