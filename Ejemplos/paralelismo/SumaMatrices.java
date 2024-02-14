import java.util.ArrayList;
import java.util.List;

public class SumaMatrices implements Runnable {
    int[][] matrizA;
    int[][] matrizB;
    int[][] resultado;

    public SumaMatrices(int[][] matrizA, int[][] matrizB){
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.resultado = new int[matrizA.length][matrizA.length];
    }

    public void sumaSecuencial(){
        for(int i = 0; i < matrizA.length; i++){
            for(int j = 0; j < matrizB.length; j++){
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
    }

    @Override
    public void run(){
        sumaConcurrente();}

    public void sumaConcurrente(){
        int i = Integer.parseInt(Thread.currentThread().getName());
        for(int j = 0; j < matrizB.length; j++){
            resultado[i][j] = matrizA[i][j] + matrizB[i][j];
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int[][] a = new int[2][2];
        int[][] b = new int[2][2];
        SumaMatrices sm = new SumaMatrices(a,b);
        int HILOS = 4;

        List<Thread> hilos = new ArrayList<>();

        for(int i = 0; i < a.length; i++){//16
            Thread t = new Thread(sm,""+i);
            hilos.add(t);
            t.start();

            if(hilos.size() == HILOS){
                for(Thread h : hilos){
                    h.join();
                }
                hilos.clear();
            }
        }

        for(Thread h : hilos){
            h.join();
        }
    }
}
