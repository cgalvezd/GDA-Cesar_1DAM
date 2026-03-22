package resolAgendaContactos;

import java.util.Scanner;

public class MainConsola {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		agenda.cargar("contactos.txt");

		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		do {
			System.out.println("\n========= MENÚ AGENDA =========");
			System.out.println("1. Añadir contacto");
			System.out.println("2. Listar contactos");
			System.out.println("3. Buscar en fichero");
			System.out.println("4. Guardar y salir");
			System.out.println("Elige una opción.");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1 -> {
				System.out.println("Nombre: ");
				String nombre = scanner.nextLine();
				System.out.println("Teléfono ");
				String telefono = scanner.nextLine();
				System.out.println("Email: ");
				String email = scanner.nextLine();

				Contacto c = new Contacto(nombre, telefono, email);
				agenda.añadir(c);
				System.out.println("Contacto añadido exitosamente.");
			}

			case 2 -> {
				agenda.listar();
			}
			case 3 -> {
				System.out.println("Nombre a buscar:");
				String nombreBuscado = scanner.nextLine();

				String resultado = agenda.buscarEnFichero("contactos.txt", nombreBuscado);
				if (resultado != null) {
					System.out.println("Encontrado: " + resultado);
				} else {
					System.out.println("Contacto no encontrado: " + nombreBuscado);
				}
			}
			case 4 -> {
				// VOLCAMOS TODA LA MEMORIA AL DISCO DURO Y SALIMOS
				agenda.guardar("contactos.txt");
				System.out.println("4 contactos guardados en contactos.txt.");
				System.out.println("Hasta luego.");
			}
			default -> System.out.println("Opción inválida.");
			}
		} while (opcion != 4);

		scanner.close();

	}
}