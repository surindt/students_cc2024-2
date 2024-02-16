/**
 * Clase persona, nos ayuda a ver como interactua
 * @version 1.0
 * @author Kassandra Mirael
 */
public class Persona {
    private String nombre;
    private Integer hp;
    private Arma arma;

    /**
     * Metodo constructor
     * @param nombre El nombre
     * @param hp Los puntos de vida
     */
    public Persona(String nombre, Integer hp) {
        this.nombre = nombre;
        this.hp = hp;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getHp() {
        return hp;
    }
    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

}
