package resolMovimientosBancarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LectorMovimientos {

	public static HashMap<String, Double> leer(String ruta) {
		HashMap<String, Double> mapa = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			br.readLine();
			String linea;
			while ((linea = br.readLine()) != null) {
				String partes[] = linea.split(";");
				String tarjeta = partes[0];
				String comercio = partes[1];
				double importe = Double.parseDouble(partes[2]);
				String fecha = partes[3];
				mapa.merge(tarjeta, importe, Double::sum);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
		return mapa;

	}

}
