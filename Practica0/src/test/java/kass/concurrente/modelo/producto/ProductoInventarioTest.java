package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoInventarioTest {
    ProductoInventario p1,p2;


    @BeforeEach
    void setUp(){
        p1 = new ProductoInventario("Test", 10.);
        p2 = new ProductoInventario("Test2",10.,10);
    }

    @Test
    void constructorTest(){
        assertTrue(p1 != null && p2 != null);
    }
}
