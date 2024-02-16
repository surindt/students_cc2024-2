/**
 * Una lanza es una arma.
 * Una lanza ataca y puede genera x cantidad de danno
 * Puede modificar otras estadisticas tambien, pero para fines practicos
 * Solo imprime un msg y el danno
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Lanza implements Arma{
    
    @Override
    public void ataca(Persona p) {
        System.out.println("Se ataco con Lanza");
        p.setHp(p.getHp()-12);
    }
}
