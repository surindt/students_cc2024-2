public class Personaje implements Runnable{
    private String name;
    private int contador;
    private int rondas;

    public Personaje(String name){
        this.name = name;
        contador = 0;
        rondas = 5;
    }

    @Override
    public void run(){
        for(int i = 0; i<rondas; ++i){
            contador++;
        }
    }

    public static void main(String[] args) {
        
        Personaje p = new Personaje("p");
        p.run();

        Thread t = new Thread(p);
        t.start();
    }
}
