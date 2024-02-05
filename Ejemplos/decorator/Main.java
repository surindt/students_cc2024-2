/**
 * Clase Principal para mostrar el ejemplo
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Weapon weapon = new BaseWeapon("ARMA BASE", 10, 10);//Creamos el arma base
        //weapon.funcionalidad(); //descomenta para ver que pasa

        Weapon weaponConMira = new Mira(weapon); //creamos el arma con mira
        //weaponConMira.funcionalidad(); //Descomenta

        Weapon silenciado = new Silencer(weaponConMira); //Se crea silenciador con el armo
        silenciado.funcionalidad(); //Arma completa
    }
}
