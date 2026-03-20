package ejerProgramacion.Bancario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorAlertas {
	public static void escribir(String ruta, String tarjeta, double total) {
		// Abro el fichero en modo append para no sobreescribir alertas previas
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
			bw.write(tarjeta + ";" + String.format("%.2f", total) + ";ALERTA");
			bw.newLine();
		} catch (IOException e) {
			System.err.println("Error al escribir alerta: " + e.getMessage());
		}
	}

	public static boolean yaRegistrada(String ruta, String tarjeta) {
		// Compruebo si la tarjeta ya está en alertas
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.startsWith(tarjeta)) {
					return true; // La tarjeta ya fue alertada
				}
			}
		} catch (FileNotFoundException e) {
			// Si el fichero no existe, no hay alertas previas
			return false;
		} catch (IOException e) {
			System.err.println("Error al leer alertas: " + e.getMessage());
		}
		return false; // No encontrada
	}
}