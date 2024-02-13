package kass.concurrente;

import kass.concurrente.constants.Constante;
import kass.concurrente.crypto.Cifrar;

/**
 * Clase Principal
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(Cifrar.descifraC(Constante.LLAVE, Constante.CONTRASENNA));

        System.out.println("Practica 2");
    }
}