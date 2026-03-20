package practicasUnidad6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaApp {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Map<String, String> contacts = new HashMap<>();
boolean isRunning = true;

while (isRunning) {
System.out.println("\n--- AGENDA ---");
System.out.println("1. Añadir contacto");
System.out.println("2. Ver contactos");
System.out.println("3. Salir");
System.out.print("Elige una opción: ");

String option = scanner.nextLine();

switch (option) {
case "1":
System.out.print("Nombre: ");
String name = scanner.nextLine();
System.out.print("Teléfono: ");
String phone = scanner.nextLine();

// Saves the contact using the name as the key
contacts.put(name, phone);
System.out.println("¡Contacto guardado con éxito!");
break;

case "2":
System.out.println("\nLista de contactos:");
if (contacts.isEmpty()) {
System.out.println("La agenda está vacía.");
} else {
// Iterates through the map to display all saved contacts
for (Map.Entry<String, String> entry : contacts.entrySet()) {
System.out.println("- " + entry.getKey() + ": " + entry.getValue());
}
}
break;

case "3":
isRunning = false;
System.out.println("Saliendo de la agenda...");
break;

default:
System.out.println("Opción no válida. Inténtalo de nuevo.");
}
}

scanner.close();
}
}