package com.example.extrahilos.Hilos;

public class Contador implements Runnable{
    static  int contador = 0;
    private final int rondas = 10000;

    @Override
    public void run(){
        for(int i = 0; i < rondas; ++i){
            ++contador;
        }
    }

    public synchronized void contador(){
        for(int i = 0; i < rondas; ++i){
            ++contador;
        }
    }
}
