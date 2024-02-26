package kass.concurrente.candadosImp;

import kass.concurrente.candados.Lock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FiltroLockTest {
    Lock lock;
    static final Integer CAPACIDAD = 6;
    static final Integer RONDAS = 15000;
    static Integer aprovacion = 0;
    Boolean esCorrecto;
    AtomicInteger atomicInteger;
    Thread[] hilos;

    @BeforeEach
    void  setUp(){
        lock = new FiltroLock(CAPACIDAD);
        esCorrecto = true;
        atomicInteger = new AtomicInteger(0);
        initThreads();
    }

    void initThreads(){
        hilos = new Thread[CAPACIDAD];
        for(int i = 0; i < CAPACIDAD-1; ++i){
            hilos[i] = new Thread(this::adquiereRondas, String.format("%d",i));
        }
        hilos[CAPACIDAD-1] = new Thread(this::verifica);
    }

    void adquiereRondas(){
        long valor = 0;
        for(int i = 0; i < RONDAS; ++i){
            lock.lock();
            this.atomicInteger.incrementAndGet();
            valor += this.simulaCS(Math.random()*100);
            if((i % 1000) == 0){
                this.duermeHilos(Math.random()*10);
            }
            this.atomicInteger.decrementAndGet();
            lock.unlock();
        }
        System.out.printf("%s valor alcanzado %d\n", Thread.currentThread().getName(), valor);
    }

    Integer simulaCS(Double iteraciones){
        int valor = 0;
        for(int j = 0; j < iteraciones; ++j){
            valor += j & 1;
        }
        return valor;
    }

    void verifica() {
        for(int i = 0; i < (CAPACIDAD * RONDAS); i++) {
            for(int j = 0; j < Math.random() * 100; j++) {
                esCorrecto = esCorrecto && (atomicInteger.get() <= 1);
                if(atomicInteger.get() <= 1) ++aprovacion;
            }
            if((i % 6000) == 0) {
                duermeHilos(Math.random() * 50);
            }
        }
        System.out.printf("%s verificacion finalizada %s\n", Thread.currentThread().getName(), esCorrecto);
    }

    void duermeHilos(Double aproxMillisec) {
        try {
            Thread.sleep(aproxMillisec.longValue());
        } catch(InterruptedException ie) {
            System.out.printf("%s  - Algo paso D:", Thread.currentThread().getName());
            throw new RuntimeException("D: :'v'.");
        }
    }

    @Test
    void semaforoTest() throws InterruptedException {
        for(Thread t : hilos){
            t.start();
        }
        for(Thread t : hilos){
            t.join();
        }
        System.out.println("Aprovacion del "+ aprovacion);
        assertTrue(esCorrecto);
    }


}
