package ejerProgramacion.Bancario;

import java.util.HashMap;
import java.util.Map;

public class GestorMovimientos {

	public static int procesar(String rutaEntrada, String rutaSalida, double limite) {
		HashMap<String, Double> mapa = LectorMovimientos.leer(rutaEntrada);
		int alertas = 0;
		for (Map.Entry<String, Double> entry : mapa.entrySet()) {
			String tarjeta = entry.getKey();
			double total = entry.getValue();
			if (total > limite && !EscritorAlertas.yaRegistrada(rutaSalida, tarjeta)) {
				EscritorAlertas.escribir(rutaSalida, tarjeta, total);
				alertas++;
			}
		}
		return alertas; // Devuelvo número de alertas generadas
	}

	public static void imprimirResumen(HashMap<String, Double> mapa, double limite) {
		System.out.println("===== CONTROL DE MOVIMIENTOS =====");
		System.out.printf("%-30s %10s %s%n", "Tarjeta", "Total (€)", "Estado");
		System.out.println("----------------------------------");
		for (Map.Entry<String, Double> entry : mapa.entrySet()) {
			String estado = entry.getValue() > limite ? "ALERTA" : "OK";
			System.out.printf("%-30s %10.2f € %s%n", entry.getKey(), entry.getValue(), estado);
		}
		System.out.println("----------------------------------");
		System.out.println("Tarjetas analizadas : " + mapa.size());
	}
}