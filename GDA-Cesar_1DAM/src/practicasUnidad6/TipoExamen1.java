package practicasUnidad6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TipoExamen1 {
	public static void main(String[] args) {
		// PRIMERO DEBES DEFINIR LOS OBJETOS FILE
		// ESTOS REPRESENTAN LA RUTA/ARCHIVO, NO EL CONTENIDO.

		File origin = new File("archivo.txt");

		File destination = new File("destination.txt");

		int count = 0;

		// 2.Verificamos si el archivo existe.
		if (origin.exists()) {
			System.out.println("Error. File " + origin.getName() + " doesn't exist.");
		}

		try (
				// Pasamos el objeto File al FileReader
				BufferedReader br = new BufferedReader(new FileReader(origin));
				PrintWriter pw = new PrintWriter(new FileWriter(destination))) {
			String line;
			System.out.println("Reading... " + origin.getAbsolutePath());

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				count++;
			}

			// Escritura del resumen
			pw.println("Total lines: " + count);
			System.out.println("\nFile " + destination.getName() + " created.");
		} catch (IOException e) {
			System.err.println(e.getMessage());

		}
	}
}