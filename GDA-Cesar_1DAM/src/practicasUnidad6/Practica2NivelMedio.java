package practicasUnidad6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practica2NivelMedio {
	public static void main(String[] args) {
		File origin = new File("origin.txt");
		File destination = new File("Destination");

		// Verificamos si el archivo de origen existe
		if (!origin.exists()) {
			System.out.println("ERROR: Origin file doesn't exist.");
			return;
		}
		try {
			// Estamos leyendo los valores del archivo origin
			Scanner scanner = new Scanner(origin);
			// Y los estamos escribiendo en el archivo destination
			FileWriter fw = new FileWriter(destination);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				fw.write(line + "\n");
			}

			fw.close();
			scanner.close();
			System.out.println("Copy has been made it successfully.");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File doesn't exists.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}