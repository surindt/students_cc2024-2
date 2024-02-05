public class Main {
    public static void main(String[] args) {
        Weapon weapon = new BaseWeapon("ARMA BASE", 10, 10);
        //weapon.funcionalidad();

        Weapon weaponConMira = new Mira(weapon);
        //weaponConMira.funcionalidad();

        Weapon silenciado = new Silencer(weaponConMira);
        silenciado.funcionalidad();
    }
}
