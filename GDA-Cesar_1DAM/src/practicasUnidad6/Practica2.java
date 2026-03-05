package practicasUnidad6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Practica2 {
	public static void main(String[] args) {
		// Definimos las 5 frases que serán escritas en el código
		String[] frases = { "Java 17 es genial", "Manejo de archivos", "Eclipse IDE", "Programación",
				"Fin de archivo" };

		// El Writer se utiliza para enviar datos hacia el disco duro.
		// El motor de escritura (FileWriter + BufferedWriter)
		// FileWriter es el encargado de abrir o crear el archivo físico 'salida.txt'.
		// Por defecto, si el archivo ya existe, FileWriter borra todo el contenido
		// anterior y lo sobreescribe desde cero.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"))) {
			for (String f : frases) {
				// bw.write(f): Envía el contenido de la variable f al buffer
				bw.write(f);
				// Salto de línea.
				bw.newLine();
			}
			System.out.println("Archivo 'salida.txt' creado con éxito");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}