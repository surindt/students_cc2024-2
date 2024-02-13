package kass.concurrente;

import kass.concurrente.constants.Constante;
import kass.concurrente.crypto.Cifrar;

/**
 * Clase Principal
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Long inicio = System.nanoTime();
        System.out.println(Cifrar.descifraC(Constante.LLAVE, Constante.CONTRASENNA));
        Long fin = System.nanoTime();
        Long total = fin-inicio;
        System.out.println("TIEMPO TOTAL: " + nanoSegundoASegundo(total));
        System.out.println("Practica 2");
    }

    public static double nanoSegundoASegundo(Long tiempo){
        return tiempo *1.0 * Math.pow(10,-9);
    }
}