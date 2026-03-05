package practicasUnidad6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Practica3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// DATO: BufferedWriter.write() solo acepta String (o caracteres).
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos.txt"))) {
			// Pedimos el dato
			System.out.println("Write your name: ");
			// Lo capturamos y lo guardamos en name
			String name = scanner.nextLine();
			// Lo escribimos en bw
			bw.write(name);
			// Línea nueva
			bw.newLine();

			System.out.println("Write your age: ");
			int age = scanner.nextInt();
			scanner.nextLine(); // Limpieza de buffer
			bw.write(String.valueOf(age)); // Esto convierte el int a String
			bw.newLine();

			System.out.println("Write your city: ");
			String city = scanner.nextLine();
			bw.write(city);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
