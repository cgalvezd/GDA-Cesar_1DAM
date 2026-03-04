package practicasUnidad6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BasicFileIO {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		File file = new File("exam_data.txt");

		System.out.println("Enter number of records: ");
		int records = scanner.nextInt();
		scanner.nextLine(); // Limpieza de buffer

		// Validamos si el archivo ya existe.
		if (file.exists()) {
			System.out.println("File already exists. ");
		}

		// Apertura del FileWriter en modo append
		try {
			FileWriter writer = new FileWriter(file, true);

			// Pedimos valores
			for (int i = 0; i < records; i++) {
				System.out.println("Enter the student name:  ");
				String name = scanner.nextLine();

				System.out.println("Enter the student grade: ");
				double grade = scanner.nextDouble();
				scanner.nextLine();

				// Formateamos la salida antes de escribir
				String formattedData = String.format("Name: %s | Grade: %.2f\n", name, grade);
				writer.write(formattedData);
			}

			writer.close();
			System.out.println("Data saved successfully.");

		} catch (IOException e) {
			System.err.println("I/O Error: " + e.getMessage());
		}

		// -------------------------------
		// NUEVA PARTE: LECTURA DEL FICHERO
		// -------------------------------

		System.out.println("\n--- Reading file content ---");

		// Como el file ya está creado, lo verificadmos
		if (!file.exists()) {
			System.out.println("ERROR: The file exam_data.txt does not exist.");
			scanner.close();
			return;
		}

		// Si el archivo existe, lo leemos con Scanner

		try {
			Scanner fileScanner = new Scanner(file);

			// Con esto, leemos cada línea del file
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}

		scanner.close();

	}
}