package resolFlashGo;

public class Furgoneta extends Vehiculo {
	private final double COSTE_POR_KG = 0.6;
	private final double RECARGO_COMBUSTIBLE = 5;
	private final double RECARGO_PAQUETE_URGENTE = 2;

	public Furgoneta(double pesoMaximo, double volumenMaximo) {
		super(pesoMaximo, volumenMaximo);
	}

	@Override
	public void cargar(Paquete p) {
		if (cabePaquete(p)) {
			this.paquetesCargados.add(p);
			System.out.println("Paquete cargado: " + p.getNombre());
		} else {
			System.out.println("Vehículo lleno, no puedes agregar el paquete: " + p.getNombre());
		}

	}

	@Override
	public double calcularCoste() {
		double coste = 0;
		for (Paquete p : paquetesCargados) {

			coste += (p.getPeso() * COSTE_POR_KG);

			if (p.getPrioridad() == Prioridad.URGENTE) {
				coste += RECARGO_PAQUETE_URGENTE;
			}
		}
		if (!paquetesCargados.isEmpty()) {
			coste += RECARGO_COMBUSTIBLE;
		}
		return coste;
	}

}
