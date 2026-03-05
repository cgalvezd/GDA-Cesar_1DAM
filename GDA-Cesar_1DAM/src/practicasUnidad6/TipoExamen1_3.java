package practicasUnidad6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TipoExamen1_3 {

	public static void main(String[] args) {
		File students = new File("students.txt");
		File adults = new File("adults.txt");
		File summary = new File("summary.txt");

		int count = 0;
		int countAdults = 0;

		try (PrintWriter pw = new PrintWriter(new FileWriter(students))) {
			pw.println("Laura;19;Madrid");
			pw.println("Carlos;22;Sevilla");
			pw.println("Marta;20;Valencia");
			pw.println("Juan Carlos;22;Barcelona");
			pw.println("Juan Asturias;24;Málaga");
		} catch (IOException e) {
			e.printStackTrace();

		}
		// Con esto, estoy leyendo los registros de 'students'
		try (
			BufferedReader br = new BufferedReader(new FileReader(students));
			PrintWriter pwAdults = new PrintWriter(new FileWriter(adults))
		) {

			String line;
			System.out.println("Listado de estudiantes: ");
			
			while ((line = br.readLine()) != null) {
				// Para imprimir el texto en otro formato, primer debo dividir el contenido
				// Para ello, utilizaré un array y la ',' como separador
				String[] partes = line.split(",");
				

				// Ahora extraemos y limpiamos los datos (trim() quita espacios extra)
				String name = partes[0].trim();
				String age = partes[1].trim();
				String city = partes[2].trim();

				// Imprimimos con el nuevo formato
				System.out.printf("Name: %-15s | Age: %-3s | City: %s%n", name, age, city);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nTotal de estudiantes: " + count);
	}
}