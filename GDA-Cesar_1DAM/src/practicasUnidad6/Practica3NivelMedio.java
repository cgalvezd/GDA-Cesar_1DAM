package practicasUnidad6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practica3NivelMedio {
	public static void main() {

		Scanner scanner = new Scanner(System.in);

		File origin = new File("Origin.txt");
		File destination = new File("Destination.txt");

		if (!origin.exists()) {
			System.out.println("File Doesn't exist. ");
			return;
		}

		System.out.println("¿Qué palabra vas a bucar?");
		String word = scanner.nextLine();

		try {
			Scanner sc = new Scanner(origin);
			FileWriter fw = new FileWriter(destination);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.contains(word)) {
					fw.write(line + "\n");
				}
			}

			fw.close();
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}