public class Mira extends WeaponDecorator{

    public Mira(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void funcionalidad(){
        super.funcionalidad();
        System.out.println("Se ha annadido la Mira :D");
    }
    
}
