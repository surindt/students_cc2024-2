public class Silencer extends WeaponDecorator{

    public Silencer(Weapon weapon) {
        super(weapon);
    }

    @Override
    public void funcionalidad(){
        super.funcionalidad();
        System.out.println("Se ha annadido el silenciado :D");
    }
    
}
