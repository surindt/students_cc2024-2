public abstract class WeaponDecorator implements Weapon{

    private final Weapon weapon;

    public WeaponDecorator(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public void funcionalidad() {
        this.weapon.funcionalidad();
    }
    
}
