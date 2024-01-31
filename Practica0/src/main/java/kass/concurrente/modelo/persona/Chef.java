package kass.concurrente.modelo.persona;
import kass.concurrente.modelo.cuchillo.Cuchillo;

public class Chef extends Persona{
    /* Cuchillo */
   Cuchillo cuchillo;

    /* Constructor usando super*/
    public Chef(String nombre, Integer edad, Cuchillo cuchillo){
        super(nombre,edad);
        this.cuchillo = cuchillo;
    }
}
