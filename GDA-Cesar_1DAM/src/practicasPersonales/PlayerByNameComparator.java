package practicasPersonales;

import java.util.Comparator;

// 1. Implementamos Comparator con el genérico <Player>
public class PlayerByNameComparator implements Comparator<Player> {

    // 2. Implementamos el método compare con DOS parámetros
    @Override
    public int compare(Player p1, Player p2) {
        
        // Delegamos la comparación alfabética al método compareTo de la clase String
        // El String ya sabe cómo ordenarse alfabéticamente de la A a la Z
        return p1.getNickname().compareTo(p2.getNickname());
        
        // Si quisiéramos orden alfabético inverso (de la Z a la A):
        // return p2.getNickname().compareTo(p1.getNickname());
    }
}