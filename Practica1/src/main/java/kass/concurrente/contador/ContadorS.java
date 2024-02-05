package kass.concurrente.contador;

public class ContadorS implements Runnable {
    private static final int RONDAS = 10000;
    private int valor;

    /** Metodo constructor. */
    public ContadorS() {
        this.valor = 0;
    }

    /**
     * Metodo que obtiene el valor.
     * @return El valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * Metodo que asigna un nuevo valor.
     * @param valor El nuevo valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public void run() {
        suma();
    }

    public synchronized void suma(){
        for(int i = 0; i < RONDAS; ++i){
            valor = valor + 1;
        }
    }

/*     public void suma(){
        synchronized(this){
            for(int i = 0; i < RONDAS; ++i){
                valor = valor + 1;
            }
        }
    } */

    public static void main(String[] args) throws InterruptedException {
        ContadorS c = new ContadorS();

        Thread h1 = new Thread(c,"1");
        Thread h2 = new Thread(c,"2");

        h1.start();h2.start();

        h1.join();h2.join();

        System.out.println("EL VALOR ES: " + c.getValor());
    }
}
