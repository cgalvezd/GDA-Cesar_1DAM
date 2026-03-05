package practicasUnidad6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Practica1NivelMedio {
	public static void main(String[] args) {
		int suma = 0, contador = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("numeros.txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				suma += Integer.parseInt(linea.trim());
				contador++;
			}
			if (contador > 0) {
				System.out.println("Suma: " + suma);
				System.out.println("Promedio: " + (double) suma / contador);
			}
		} catch (IOException | NumberFormatException e) {
			System.err.println("Error en los datos o archivo no encontrado.");
		}
	}
}