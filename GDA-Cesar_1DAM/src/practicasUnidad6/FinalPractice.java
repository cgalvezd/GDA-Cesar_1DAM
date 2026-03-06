package practicasUnidad6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FinalPractice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		File file = new File("inventario.txt");

		if (file.exists()) {
			System.out.println("File already exists.");
			return;
		}

		// Entrada de datos
		System.out.println("Cuantos artículos deseas registrar. ");
		int total = scanner.nextInt();
		scanner.nextLine();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			 BufferedReader br = new BufferedReader(new FileReader(file))) {

			for (int i = 0; i < total; i++) {
				System.out.println("Nombre del Producto: " + (i + 1));
				String name = scanner.nextLine();
				bw.write(name);

				System.out.println("Precio del producto: " + (i + 1));
				double price = scanner.nextDouble();
				bw.write(price);

			}

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}