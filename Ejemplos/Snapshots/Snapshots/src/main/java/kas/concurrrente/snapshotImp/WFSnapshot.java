package kas.concurrrente.snapshotImp;


import kas.concurrrente.candado.Lock;
import kas.concurrrente.candado.PetersonLock;
import kas.concurrrente.snapshot.Snapshot;
import kas.concurrrente.stamped.StampedSnap;

public class WFSnapshot<T> implements Snapshot<T>{
    private StampedSnap<T>[] aTable;
    Lock candado;

    public WFSnapshot(int capacity, T init){
        aTable = (StampedSnap<T>[]) new StampedSnap[capacity];
        candado = new PetersonLock();

        for(int i = 0; i < aTable.length; i++){
            aTable[i] = new StampedSnap<>(init);
        }
    }

    @Override
    public void update(T value) {
        int id = Integer.parseInt(Thread.currentThread().getName());
        T[] snap = scan();
        //System.out.println("PASO SCAN");
        StampedSnap<T> oldValue = aTable[id];
        StampedSnap<T> newValue = new StampedSnap<>(oldValue.getStamp()+1,value,snap);
        aTable[id] = newValue;
    }

    @Override
    public T[] scan() {
        StampedSnap<T>[] oldCopy, newCopy;
        boolean[] moved = new boolean[aTable.length];
        oldCopy = collect();
        //System.out.println("PASO COLLECT SCAN");
        collect : while(true){
            newCopy = collect();
            for(int j = 0; j < aTable.length; j++){
                //System.out.println("CONDICION IF "+ (oldCopy[j].getStamp() != newCopy[j].getStamp()));
                if(oldCopy[j].getStamp() != newCopy[j].getStamp()){
                    if(moved[j]){
                        return oldCopy[j].getSnap();
                    }else{
                        //System.out.println("Dentro ELSE");
                        moved[j] = true;
                        oldCopy = newCopy;
                        continue collect;
                    }
                }
            }
            T[] result = (T[]) new Object[aTable.length];
            for(int j = 0; j < aTable.length; j++){
                result[j] = newCopy[j].getValue();
            }
            return result;
        }
    }
    
    /**
     * Metodo que obtiene una copia de los valores del arreglo
     * @return La copia de los valores del arreglo
     */
    private StampedSnap<T>[] collect(){
        //System.out.println("COLLECT");
        StampedSnap<T>[] copy = (StampedSnap<T>[]) new StampedSnap[aTable.length];
        for(int j = 0; j < aTable.length; j++){
            copy[j] = aTable[j];
        }
        return copy;
    }

    public StampedSnap<T>[] getATable(){
        return aTable;
    }

    public T getStampedSnap(int pos){
        return (T) aTable[pos].getValue();
    }
}
