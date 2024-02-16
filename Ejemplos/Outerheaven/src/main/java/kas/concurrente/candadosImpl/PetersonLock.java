package kas.concurrente.candadosImpl;


import kas.concurrente.candados.Lock;



public class PetersonLock implements Lock {
    volatile boolean banderas[] = {false,false};
    volatile int victima;


    public PetersonLock(){
        
    }

    @Override
    public void lock() {
        int id = Integer.parseInt(Thread.currentThread().getName());
        banderas[id] = true;
        victima = id;
        while (banderas[1-id] && victima == id);
        
    }

    @Override
    public void unlock() { 
        int id = Integer.parseInt(Thread.currentThread().getName());
        banderas[id] = false;
    }


}
