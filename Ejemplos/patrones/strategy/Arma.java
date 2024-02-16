/**
 * Interfaz de Arma, es un ejemplo del Patron Strategy
 * @author Kassandra Mirael
 * Un arma nos sirve para atacar, pero hay distintos tipos de arma
 */
public interface Arma {
    /**
     * Metodo que ataca a una persona
     * @param p La persona a atacar
     */
    public void ataca(Persona p);
}
