public class HilosR {

    public static void main(String[] args) throws InterruptedException {
        HilosR h = new HilosR();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Hola soy el: " + Thread.currentThread().getName());
            }

        }, "Hilo 1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola soy el: " + Thread.currentThread().getName());
            }
        }, "Hilo 2");

        t1.start();t2.start();

        t1.join();t2.join();
    }
    
}
