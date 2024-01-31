package kass.concurrente.modelo.producto;

/**
 * Clase que modela un platillo
 * @author Kassandra Mirael
 */
public class Platillo {
    /* Cada platillo tiene tiempo de elaboración en minutos*/
    private float tiempoElaboracion;

    /* */

    /**
     * Este metodo calcula el precio sobre el precio de los items, se ignora
     * el precio base.
     * @return El precio de la suma de cada item utilizado
     */
    public Double calculaPrecio(){
        return 0.;
    }
    
}
