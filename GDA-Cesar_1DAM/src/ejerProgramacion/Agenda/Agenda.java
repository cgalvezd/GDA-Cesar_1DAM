package ejerProgramacion.Agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Agenda {

    // 🔹 Lista interna de contactos
    private ArrayList<Contacto> contactos;

    // 🔹 Constructor
    public Agenda() {
        contactos = new ArrayList<>();
    }

    // 🔹 Añadir contacto
    public void anadir(Contacto c) {
        contactos.add(c);
    }

    // 🔹 Listar contactos formateado
    public void listar() {

        // Cabecera
        System.out.printf("%-25s  %-15s  %-30s%n", "NOMBRE", "TELEFONO", "EMAIL");
        System.out.printf("%-25s  %-15s  %-30s%n",
                "-------------------------",
                "---------------",
                "------------------------------");

        // Datos
        for (Contacto c : contactos) {
            System.out.printf("%-25s  %-15s  %-30s%n",
                    c.getNombre(),
                    c.getTelefono(),
                    c.getEmail());
        }
    }
    
    public void guardar(String ruta) {

        // try-with-resources → cierra automáticamente el fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

            // Recorremos todos los contactos
            for (Contacto c : contactos) {
                bw.write(c.toString()); // escribe: nombre;telefono;email
                bw.newLine(); // salto de línea
            }

            // Mensaje de confirmación
            System.out.println(contactos.size() + " contactos guardados en " + ruta + ".");

        } catch (IOException e) {
            System.out.println("Error al guardar el fichero: " + e.getMessage());
        }
    }
    
    public void cargar(String ruta) {

        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            // Leer línea a línea
            while ((linea = br.readLine()) != null) {

                // Separar por ";"
                String[] partes = linea.split(";");

                // Validación básica (muy pro)
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String telefono = partes[1];
                    String email = partes[2];

                    Contacto c = new Contacto(nombre, telefono, email);
                    contactos.add(c);
                    contador++;
                }
            }

            System.out.println(contador + " contactos cargados.");

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe. Se iniciará una agenda vacía.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
    public String buscarEnFichero(String ruta, String nombre) {

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                // Separar campos
                String[] partes = linea.split(";");

                // Comprobamos el nombre (primer campo)
                if (partes.length > 0 && partes[0].equals(nombre)) {
                    return linea; // 🔥 devolvemos la línea completa
                }
            }

        } catch (IOException e) {
            System.out.println("Error al buscar en fichero: " + e.getMessage());
        }

        return null; // 🔥 si no se encuentra
    }
    
}