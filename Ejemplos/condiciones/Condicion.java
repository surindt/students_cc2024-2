import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Condicion implements Runnable {
    private Lock lock;
    public static final int HILOS = 10;
    int contador = 0;
    boolean condicion = true;
    boolean dormir = false;
    Condition condition;

    private Condicion(){
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    @Override
    public void run() {
        try{ 
            int id = Integer.parseInt(Thread.currentThread().getName());
            if(id < 0){
                Scanner lector = new Scanner(System.in);
                int valor;
                while(condicion){
                    imprimeMenu();
                    valor = lector.nextInt();
                    switch(valor){
                        case 1:
                            continue;
                        case 2:
                            dormir = true;
                            System.out.println(dormir);
                            break;
                        case 3:
                            lock.lock();
                            condition.signalAll();
                            //dormir = false;
                            lock.unlock();
                            break;
                        case 4:
                            lock.lock();
                            condition.signal();
                            //dormir = false;
                            lock.unlock();
                            break;
                        case 5:
                            System.out.println("Contador: " + contador);
                            break;
                        case 6:
                            condicion = false;
                            dormir = false;
                            lock.lock();
                            condition.signalAll();
                            lock.unlock();
                    }
                }
                lector.close();
            }else{
                while(condicion){
                    lock.lock();
                    contador++;                   
                    if(dormir){
                            System.out.println("APAGANDO LAS LUCES");
                            condition.await();
                    }
                    lock.unlock();
                }
                System.out.println("SALIENDO  BUCLE: " +id);
            }
        }catch(Exception e){}
    }

    public void imprimeMenu(){
        System.out.println("1.- Para continuar");
        System.out.println("2.- Para pausar los hilos");
        System.out.println("3.- Para despertar todos los hilos");
        System.out.println("4.- Para despertar un hilo");
        System.out.println("5.- Imprime contador");
        System.out.println("6.- Para terminar la ejecucion");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> hilos = new ArrayList<>();
        Condicion c = new Condicion();

        for(int i = 0; i < HILOS; ++i){
            Thread t = new Thread(c,""+i);
            t.start();
            hilos.add(t);
        }

        Thread lector = new Thread(c,"-1");
        lector.start();

        for(Thread t : hilos){
            t.join();
        }

        lector.join();

        System.out.println("FIN");
    }
}