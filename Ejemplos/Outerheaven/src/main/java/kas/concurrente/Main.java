package kas.concurrente;

import kas.concurrente.candados.Lock;
import kas.concurrente.candadosImpl.DekkerLock;

public class Main implements Runnable {
    private Lock dekker;

    public Main(){
        this.dekker = new DekkerLock();
    }
    
    public static final Integer DISCOS = 10;

    public static final Double OCELOT = (9./10);

    public static final Double BOSS = (8./10);

    private Integer contadorFinal = 0;

    public Integer getContadorFinal() {
        return contadorFinal;
    }

    public void setContadorFinal(Integer contadorFinal) {
        this.contadorFinal = contadorFinal;
    }

    @Override
    public void run() {
        Integer id = Integer.parseInt(Thread.currentThread().getName());
        double prob = (id == 1)?BOSS:OCELOT;
        for(int balas = 0; balas < DISCOS; ++balas){
            dekker.lock();
            double val = Math.random();

            if(val < prob){
                contadorFinal++;//CS
            }
            dekker.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main campoDeTiro = new Main();

        Thread ocelot = new Thread(campoDeTiro,"0");

        Thread boss = new Thread(campoDeTiro,"1");

        ocelot.start();boss.start();

        ocelot.join();boss.join();

        System.out.println("CONTADOR FINAL: " + campoDeTiro.getContadorFinal());
    }
}