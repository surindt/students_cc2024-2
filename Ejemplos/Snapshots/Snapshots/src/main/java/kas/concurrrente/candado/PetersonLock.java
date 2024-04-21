package kas.concurrrente.candado;

public class PetersonLock implements Lock{
    private volatile boolean[] flag = new boolean[2];
    private volatile int victima;

    @Override
    public void lock() {
        int id = Integer.valueOf(Thread.currentThread().getName());
        flag[id] = true;//Mostramos interes en el recurso
        victima = id;//Nos hacemos la victima
        while(victima == id && flag[1-id]);//Esperamos mientras el otro intersado y sea la victima
    }

    @Override
    public void unlock() {
        int id = Integer.valueOf(Thread.currentThread().getName());
        flag[id] = false;
    }
}
