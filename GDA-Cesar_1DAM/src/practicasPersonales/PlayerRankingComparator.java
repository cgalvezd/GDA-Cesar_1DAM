package practicasPersonales;

import java.util.Comparator;

public class PlayerRankingComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        
        // 1. Primer criterio: Puntuación DESCENDENTE 
        int scoreComparison = Integer.compare(p2.getScore(), p1.getScore());
        
        // 2. Si las puntuaciones son diferentes, ya tenemos el orden. Devolvemos el resultado.
        if (scoreComparison != 0) {
            return scoreComparison;
        }
        
        // 3. Segundo criterio (Desempate): Si scoreComparison es 0, comparamos por Nickname ASCENDENTE 
        return p1.getNickname().compareTo(p2.getNickname());
    }
}