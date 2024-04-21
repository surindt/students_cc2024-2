package kas.concurrrente;

import java.util.Scanner;

import kas.concurrrente.snapshot.Snapshot;
import kas.concurrrente.snapshotImp.WFSnapshot;

public class Main implements Runnable {
    private Snapshot<Integer> almacen;
    private Scanner lector;
    private boolean continuar;

    public Main(int capacitdad){
        this.almacen = new WFSnapshot<Integer>(capacitdad, 0);
        lector = new Scanner(System.in);
        this.continuar = true;
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Verificador")){
            System.out.println("DEntro verificador");
            while(continuar){
                System.out.println("1 para continuar, otro numero para terminar");
                continuar = (lector.nextInt() == 1);
            }
            lector.close();
        }else{
            int contador = 0;
            while(continuar){
                //System.out.println("HILO: " + Thread.currentThread().getName());

                almacen.update(contador);
                contador +=1;
            }
        }
    }

    /**
     * Metodo que imprime un arreglo de enteros
     * @param almacen El arreglo de enteros
     */
    public static void imprime(Object[] almacen){
        for(int i = 0; i < almacen.length; ++i){
            System.out.println("Lugar: " + i + " con almacenamiento de " + almacen[i]);
        }
    }


    public Snapshot<Integer> getAlmacen(){
        return almacen;
    }

    public void setAlmacen(Snapshot<Integer> almacen){
        this.almacen = almacen;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Practica 4 xd");
        Main m = new Main(10);

        Thread[] productores  = new Thread[10];
        Thread verificador = new Thread(m,"Verificador");

        for(int i = 0; i < productores.length; i++){
            productores[i] = new Thread(m, ""+i);
        }

        for(int i = 0; i < productores.length; i++){
            productores[i].start();
        }
        verificador.start();

        for(int i = 0; i < productores.length; i++){
            productores[i].join();
        }
        verificador.join();
        imprime(m.getAlmacen().scan());
    }
}