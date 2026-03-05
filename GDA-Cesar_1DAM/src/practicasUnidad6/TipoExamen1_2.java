package practicasUnidad6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TipoExamen1_2 {
	public static void main(String[] args) {

		File origin = new File("report.txt");
		File destination = new File("sumarry.txt");

		int count = 0;

		if (!origin.exists()) {
			System.out.println("File " + origin.getName() + " doesn't exist.");
		}

		try (BufferedReader bf = new BufferedReader(new FileReader(origin));
				PrintWriter pw = new PrintWriter(new FileWriter(destination))) {
			String line;
			System.out.println("Reading... file " + origin.getAbsolutePath());

			while ((line = bf.readLine()) != null) {
				System.out.println(line);
				count++;
			}

			// Escritura del resumen
			System.out.println("Total lines: " + count);
			System.out.println("\nFile " + destination.getName() + " created.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}