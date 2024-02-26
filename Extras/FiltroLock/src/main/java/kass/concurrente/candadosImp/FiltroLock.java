package kass.concurrente.candadosImp;

import kass.concurrente.candados.Lock;

public class FiltroLock  implements Lock {

    public FiltroLock(Integer capacidad){

    }

    @Override
    public void lock() {

    }

    @Override
    public void unlock() {

    }

    /**
     * Metodo que nos dice la capacidad del Filtro
     * @return La capacidad del Filtro
     */
    public int capacidad(){
        return -1;
    }
}
