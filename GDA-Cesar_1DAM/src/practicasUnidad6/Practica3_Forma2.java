package practicasUnidad6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Practica3_Forma2 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in); PrintWriter pw = new PrintWriter("usuario.txt")) {

			System.out.println("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.println("Edad: ");
			String edad = scanner.nextLine();
			System.out.println("Ciudad: ");
			String ciudad = scanner.nextLine();

			pw.println(nombre);
			pw.println(edad);
			pw.println(ciudad);
			System.out.println("Datos guardados correctamente.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}