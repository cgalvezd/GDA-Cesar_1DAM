package practicasPersonales;

//1. Implementamos Comparable y usamos el Genérico <Player>
public class Player implements Comparable<Player> {

 private String nickname;
 private int score;

 public Player(String nickname, int score) {
     this.nickname = nickname;
     this.score = score;
 }

 public String getNickname() {
     return nickname;
 }

 public int getScore() {
     return score;
 }

 // 2. Sobrescribimos el método compareTo
 @Override
 public int compareTo(Player otherPlayer) {
     // Truco de profesional/examen: NUNCA restes (this.score - otherPlayer.score) 
     // porque puede dar un error de desbordamiento (overflow) si hay números negativos.
     // Usa siempre los métodos "compare" de las clases envoltorio.
     
     // Como queremos orden DESCENDENTE (mayor a menor), invertimos el orden de los parámetros:
     return Integer.compare(otherPlayer.score, this.score);
     
     // Si quisiéramos orden ascendente sería: 
     // return Integer.compare(this.score, otherPlayer.score);
 }

 @Override
 public String toString() {
     return nickname + " - " + score + " pts";
 }
}