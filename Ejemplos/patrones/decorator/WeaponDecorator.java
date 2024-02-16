/**
 * Clase abstracta, de aqui se generaran los Decoradores
 * Iniciamos con una Weapon, que es a lo que aplicaremos el decorador
 * Sobreescribimos funcionalidad, jalando la funcionalidad del Weapon
 * Al final, en terminos de programacion, ambas cosas terminaran siendo Weapons
 * @author Kassandra Mirael
 * @version 1.0
 */
public abstract class WeaponDecorator implements Weapon{

    private final Weapon weapon;

    /**
     * Metodo constructor
     * @param weapon El weapon al que le aplicaremos el decorador
     */
    public WeaponDecorator(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public void funcionalidad() {
        this.weapon.funcionalidad();//Jalamos la funcionalidad, para estar extendiendo
    }
    
}
