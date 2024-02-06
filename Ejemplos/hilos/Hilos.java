public class Hilos implements Runnable {//Thread vs Runnable, deventaja? Es lo mismo?
    public static int contador = 0;
    public static final int RONDAS = 20000;


    @Override
    public void run() {
        System.out.println("Hola soy el: " + Thread.currentThread().getName());

        for(int i = 0; i < RONDAS; ++i) {
            contador = contador + 1;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Hilos h = new Hilos();

        Thread t1 = new Thread(h,"Hilo 1");
        Thread t2 = new Thread(h,"Hilo 2");

        t1.start();t2.start();

        t1.join();t2.join();

        System.out.println("Valor del contador: " +contador);

        System.out.println("FIN");
    }

}
