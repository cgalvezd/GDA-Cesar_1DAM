package resolAgendaContactos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contacto> listaContactos = new ArrayList<>();

	public void guardar(String ruta) {

		// EL FILEWRITER CON TRUE PARA MODO APPEND
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
			for (Contacto c : listaContactos) {
				bw.write(c.toString());
				bw.newLine();
			}

		} catch (IOException e) {
			System.out.println("Error al guardar el fichero: " + e.getMessage());

		}

	}

	public void cargar(String ruta) {
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String partes[] = linea.split(";");
				Contacto c = new Contacto(partes[0], partes[1], partes[2]);
				this.listaContactos.add(c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void añadir(Contacto c) {
		this.listaContactos.add(c);
	}

	public void listar() {
		System.out.printf("%-25s %-15s %-30s%n", "NOMBRE", "TELEFONO", "EMAIL");
		System.out.printf("%-25s  %-15s  %-30s%n", "-------------------------", "----------------",
				"------------------------------");
		for (Contacto c : listaContactos) {
			System.out.printf("%-25s %-15s %-30s%n", c.getNombre(), c.getTelefono(), c.getEmail());
		}
	}

	// METODO BUSCAR POR NOMBRE
	public String buscarEnFichero(String ruta, String nombre) {
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String partes[] = linea.split(";");
				if (partes[0].equals(nombre)) {
					return linea;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}