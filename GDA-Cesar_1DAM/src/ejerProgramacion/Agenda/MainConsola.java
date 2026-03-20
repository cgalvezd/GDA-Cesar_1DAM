package ejerProgramacion.Agenda;


import java.util.Scanner;

public class MainConsola {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        String ruta = "contactos.txt";

        // 🔹 Cargar datos al inicio
        System.out.println("Cargando datos desde " + ruta + "...");
        agenda.cargar(ruta);

        int opcion;

        do {
            // 🔹 Menú
            System.out.println("\n--------------------------------------------");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar en fichero");
            System.out.println("4. Guardar y salir");
            System.out.println("--------------------------------------------");
            System.out.print("Elige opcion: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    // Lo implementamos ahora
                    break;

                case 2:
                    agenda.listar();
                    break;

                case 3:
                    // Lo implementamos ahora
                    break;

                case 4:
                    agenda.guardar(ruta);
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}