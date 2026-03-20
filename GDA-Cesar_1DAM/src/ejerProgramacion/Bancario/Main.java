package ejerProgramacion.Bancario;

import java.util.HashMap;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		String ruta = "movimientos.csv";
		double limite = 500;

		// Modo consola
		HashMap<String, Double> mapa = LectorMovimientos.leer(ruta);
		GestorMovimientos.imprimirResumen(mapa, limite);
		int alertas = GestorMovimientos.procesar(ruta, "alertas.txt", limite);
		System.out.println("Alertas generadas   : " + alertas);
		System.out.println("Fichero alertas.txt actualizado.");

		// Modo GUI
		SwingUtilities.invokeLater(() -> new VentanaBancaria().setVisible(true));
	}

}
