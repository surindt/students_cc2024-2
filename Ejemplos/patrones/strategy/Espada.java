/**
 * Una espada es una arma.
 * Una espada ataca y puede genera x cantidad de danno
 * Puede modificar otras estadisticas tambien, pero para fines practicos
 * Solo imprime un msg y el danno
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Espada implements Arma{

    @Override
    public void ataca(Persona p) {
        System.out.println("Se ataco con espada");
        p.setHp(p.getHp()-10);
    }
    
}
