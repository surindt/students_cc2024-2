package kas.concurrente.candadosImpl;

import kas.concurrente.candados.Lock;

public class DekkerLock implements Lock{
    private volatile Boolean[] banderas = {false,false};
    private volatile int turno;

    public DekkerLock(){
        this.turno = 0;
    }

    @Override
    public void lock() {
        int id = Integer.parseInt(Thread.currentThread().getName());
        int otro = (id+1)%2;
        /* 
        * poscion[0] Corresponen al hilo 0
        * posicion[1] Corresponen al hilo 1
        * banderas[Posicion] = {,}
         * 
        */
        banderas[id] = true;//Bandera[0] = true;

        while (banderas[otro]) { //banderas[1]//true o false
            if(turno == otro){
                banderas[id] = false;
                while (turno == otro);
                banderas[id] = true;
            }
        }

    }

    @Override
    public void unlock() {
        int id = Integer.parseInt(Thread.currentThread().getName());
        int otro = (id+1)%2;
        turno = otro;
        banderas[id] = false;
    }
    
}
