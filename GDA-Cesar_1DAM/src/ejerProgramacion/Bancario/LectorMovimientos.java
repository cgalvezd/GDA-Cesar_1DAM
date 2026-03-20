package ejerProgramacion.Bancario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LectorMovimientos {

	public static HashMap<String, Double> leer(String ruta) {
		HashMap<String, Double> mapa = new HashMap<>();
		// Abro el fichero usando try-with-resources para cerrar automáticamente
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			br.readLine(); // Descarta la cabecera
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] partes = linea.split(";");
				String tarjeta = partes[0];
				double importe = Double.parseDouble(partes[2]);
				// Acumulo los importes por tarjeta
				mapa.merge(tarjeta, importe, Double::sum);
			}
		} catch (IOException e) {
			// Informo del error de lectura
			System.err.println("Error al leer el fichero: " + e.getMessage());
		}
		return mapa; // Devuelvo el mapa con totales
	}
}