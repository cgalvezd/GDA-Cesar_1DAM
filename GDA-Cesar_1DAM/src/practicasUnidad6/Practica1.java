package practicasUnidad6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Practica1 {

	public static void main(String[] args) {
		
		//Esto lee el archivo "datos.txt"
		//Todo lo que declaro dentro del () del try se cerrará automáticamente al terminar el bloque, incluso si ocurre un error.
		//FileReader abre el "tunel" físico hacia el archivo datos.txt
		//El Reader es para traer datos al programa
		try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
			//Bucle de lectura.
			//br.readLine(): El programa pide al buffer la siguiente línea de texto.
			//linea = : El contenido de esa línea se guarda en la variable linea.
			//!= null: Java verifica si la línea existe. Cuando llega al final del archivo, readLine() devuelve null, y el bucle se detiene.
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			System.err.println("ERROR: el archivo no existe o no se puede leer.");
		}
	}
}