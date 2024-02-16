/**
 * Una hacha es una arma.
 * Una hacha ataca y puede genera x cantidad de danno
 * Puede modificar otras estadisticas tambien, pero para fines practicos
 * Solo imprime un msg y el danno
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Hacha implements Arma{

    @Override
    public void ataca(Persona p) {
        System.out.println("Se ataco con Hacha");
        p.setHp(p.getHp()-8);
    }
    
}
