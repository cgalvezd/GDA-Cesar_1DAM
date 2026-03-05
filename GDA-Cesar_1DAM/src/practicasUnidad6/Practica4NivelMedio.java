package practicasUnidad6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Practica4NivelMedio {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		File file = new File("log.txt");

		System.out.println("How many log entries will you write? ");
		int quantity = scanner.nextInt();
		scanner.nextLine();

		try {
			// FileWriter in append mode
			FileWriter writer = new FileWriter(file, true);
			for (int i = 0; i < quantity; i++) {
				System.out.println("Log Nº: " + (i + 1));
				String sc = scanner.nextLine();

				writer.write(sc);
			}
			writer.close();
			System.out.println("Log saved successfully.");
			
		} catch (IOException e) {
			System.out.println("I/O Error: "+e.getMessage());
		}

		scanner.close();
	}
}