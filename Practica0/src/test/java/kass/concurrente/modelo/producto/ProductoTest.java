package kass.concurrente.modelo.producto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductoTest {
    Producto p1,p2;
    
    @BeforeEach
    void setUp(){
        p1 = new Producto("Test",10.);
        p2 = new Producto();
    }

    @Test
    void constructorTest(){
        assertNotNull(p2);
    }
}
