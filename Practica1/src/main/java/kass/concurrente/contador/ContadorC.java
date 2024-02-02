package kass.concurrente.contador;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Clase que genera un contador implementando la Interfaz Callable
 * @author Kassandra Mirael
 * @version 1.0
 */
public class ContadorC implements Callable<Integer> {
    public static Integer contador = 0;
    public static final Integer RONDAS = 10000;//Cambiar esta variable para jugar con los valores. USar Thread Sleep
    public static final Integer HILOS = 4;

    @Override
    public Integer call() throws Exception {//Esta metodo se implementa, retornamos el valor del Generico
        System.out.println("INCIO CALL");
        int total = 0;
        for(int i = 0; i< RONDAS; ++i){//Aqui tienen que hacer lo que dice en el pdf, objetivo llegar a los valores 20,000 y 30,000 y pasar dicho test
            total += 1;
            contador += 1;//Si da un error de Sonar ignorarlo, por el momento, es más didactico
        }
        return total;//Realmente esta variable es para que descubran cosas :O
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {//Mandamos 2 excepciones
        System.out.println("INICIO Programa");
        ExecutorService service = Executors.newFixedThreadPool(1); //Creamos el ExecutorService, indicamos quese usara un Thread (por el momento solo sera 1)
        List<Future<Integer>> resultados = new ArrayList<>();
        ContadorC c = new ContadorC();

        for(int i = 0; i < HILOS; ++i){
            resultados.add(service.submit(c));
        }

        Thread.sleep(2000);//Por que se usara un sleep? Explicalo en el pdf
        System.out.println(resultados.get(3).isDone());//Que significara esto? Habra una version mejor de saber cuando acabaron ya los hilos?
        if(resultados.get(1).isDone()){
            System.out.println(resultados.get(1).get());
        }
        System.out.println(contador);//Obtendremos el valor esperado?
        System.out.println("FIN Programa");
    }
}
