package kass.concurrente;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import static kass.concurrente.constantes.Contante.LOGS;

/**
 * Clase principal, se ejecuta todo la simulacion
 * Como en el cuento.
 * @author <Equipo>
 * @version 1.0
 */
public class Main implements Runnable {

    Lock lock;

    public Main(){
        lock = new ReentrantLock();
        //Agregar lo que haga falta para que funcione
    }

    /*
     * INSTRUCCIONES:
     * 1.- Ya genere el lock, es un reentrantLock, investiguen que hace
     * 2.- Tenenemos que tener un lugar el donde se albergaran los prisioneros
     * 3.- Tenemos que tener un lugar donde se albergan los Hilos
     * 4.- Se nececita un objeto de tipo Habitacion para que sea visitada
     * 5.- Aqui controlaremos el acceso a la habitacion, aunque por defecto tenia exclusion mutua
     * aqui hay que especificar el como se controlara
     * 6.- Hay que estar ITERANDO constantemente para que todos los prisiones puedan ir ingresando
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }


    public static void main(String[] args) {
        Main m = new Main();

        final Logger LOG = Logger.getLogger("paquete.NombreClase"); // EJEMPLO LOGGER

        if(LOGS) LOG.info("HOLA SOY UN MENSAJE");
    }
}