/**
 * Este caso, es muy similar a la mira
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Silencer extends WeaponDecorator{

    /**
     * Metodo constructor
     * @param weapon La arma a donde se aplicara el decorador
     */
    public Silencer(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void funcionalidad(){
        super.funcionalidad();
        System.out.println("Se ha annadido el silenciador :D");
    }
    
}
