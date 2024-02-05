/**
 * Ejemplo de interaccion
 */
public class Main {
    
    public static void main(String[] args) {
        Persona a = new Persona("Miguel",100);
        Persona b = new Persona("Bob",100);
        Arma espada = new Espada();
        Arma hacha = new Hacha();

        a.setArma(espada);
        b.setArma(hacha);

        a.getArma().ataca(b);
        b.getArma().ataca(a);

        System.out.println("Los HP de Miguel son: " +a.getHp());
        System.out.println("Los HP de Bob son: " +b.getHp());
    }
}
