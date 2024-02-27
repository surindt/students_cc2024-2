package kass.concurrente.modelos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HabitacionTest {
    Habitacion h;
    Prisionero p;
    Prisionero v;

    @BeforeEach
    void setUp(){
        h = new Habitacion();
        p = new Prisionero(0,false,false);
        v = new Vocero(1,true,false);

        h.setPrendido(false);
    }

    @Test
    void switchTest1(){
        h.entraHabitacion(p);
        assertTrue(h.getPrendido());
    }

    @Test
    void switchTest2(){
        h.setPrendido(true);
        h.entraHabitacion(v);
        assertFalse(h.getPrendido());
    }

    @Test
    void marcado(){
        h.entraHabitacion(p);
        assertTrue(p.getMarcado());
    }

    @Test
    void simSimple(){
        h.entraHabitacion(p);
        h.entraHabitacion(v);
        assertTrue(v.getContador() == 1);
    }
}
