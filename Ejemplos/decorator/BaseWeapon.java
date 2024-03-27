/**
 * Esta clase implementa Weapon, lo que hace es crear la forma base del arma
 * esta tiene atributos base aun.
 * Ademas, funciona ya por si sola
 * @version 1.0
 * @author Kassandra Mirael
 */
public class BaseWeapon implements Weapon {
    protected String nombre;
    protected Integer municion;
    protected Integer candencia;
    
    /**
     * Metodo constructor
     * @param nombre El nombre del arma
     * @param municion La cantidad de municion
     * @param candencia La candencia de disparo
     */
    public BaseWeapon(String nombre, Integer municion, Integer candencia) {
        this.nombre = nombre;
        this.municion = municion;
        this.candencia = candencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMunicion() {
        return municion;
    }

    public void setMunicion(Integer municion) {
        this.municion = municion;
    }

    public Integer isCandencia() {
        return candencia;
    }

    public void setCandencia(Integer candencia) {
        this.candencia = candencia;
    }

    @Override
    public void funcionalidad() {
        System.out.println("Arma Base");
        System.out.println("Cargador implementado");
    }
}