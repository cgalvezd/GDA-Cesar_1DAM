package resolFlashGo;

import java.util.ArrayList;

public abstract class Vehiculo {
	protected double pesoMaximo;
	protected double volumenMaximo;

	// LISTA DONDE SE GUARDAN LOS PAQUETES QUE SUBEN AL VEHÍCULO
	protected ArrayList<Paquete> paquetesCargados;

	// CONSTRUCTOR
	public Vehiculo(double pesoMaximo, double volumenMaximo) {
		this.pesoMaximo = pesoMaximo;
		this.volumenMaximo = volumenMaximo;
		this.paquetesCargados = new ArrayList<>(); // ESTO INICIALIZA LA FURGONETA/MOTO VACÍA
	}

	// 1. VALIDACION DE CARGA
	protected boolean cabePaquete(Paquete p) {
		double pesoActual = 0;
		double volumenActual = 0;

		for (Paquete cargado : paquetesCargados) {
			pesoActual += cargado.getPeso();
			volumenActual += cargado.getVolumen();
		}

		// COMPROBAR SI LO NUEVO + LO ACTUAL SUPERA EL PESO MÁXIMO
		boolean noSuperaPeso = (pesoActual + p.getPeso()) <= pesoMaximo;
		boolean noSuperaVolumen = (volumenActual + p.getVolumen()) <= volumenMaximo;

		return noSuperaPeso && noSuperaVolumen;
	}

	// 2. MÉTODO ABSTRACTO CARGAR (CADA HIJO LO HARÁ A SU MANERA).
	public abstract void cargar(Paquete p);

	// 3. SOBRECARGA DEL MÉTODO CARGAR
	// SE LLAMA IGUAL PERO RECIBE UNA LISTA DE PAQUERES EN LUGAR DE UN SOLO OBJETO
	public void cargar(ArrayList<Paquete> listaPaquetes) {
		for (Paquete p : listaPaquetes) {
			this.cargar(p); // LLAMA AL MÉTODO DE ARRIBA, UNO POR UNO.
		}

	}

	// 4. MÉTODO ABSTRACTO CALCULAR COSTE (CADA HIJO TIENE SUS TARIFAS)
	public abstract double calcularCoste();

}