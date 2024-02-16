/**
 * Clase que decora un arma
 * Es una Mira basicamente
 * Se aplica la herencia.
 * En la funcionalidad, se extendiende dicha funcionalidad
 * En este caso solo se añade la leyenda sobre la mira
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Mira extends WeaponDecorator{

    /**
     * Metodo Constructor
     * @param weapon La arma donde aplicaremos el decorador dado
     */
    public Mira(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void funcionalidad(){
        super.funcionalidad();
        System.out.println("Se ha annadido la Mira :D");
    }
    
}
