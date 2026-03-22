package resolFlashGo;

public class Moto extends Vehiculo {
	private final double COSTE_POR_KG = 0.4;
	private final double COSTE_URGENTE = 1.5;

	public Moto(double pesoMaximo, double volumenMaximo) {
		super(pesoMaximo, volumenMaximo);
	}

	@Override
	public void cargar(Paquete p) {
		if (p.isEsFragil()) {
			System.out.println("No se permiten paquetes frágiles en moto: " +p.getNombre());
			return;
		}
		if (cabePaquete(p)) {
			this.paquetesCargados.add(p);
			System.out.println("Paquete cargado: "+p.getNombre());
		} else {
			System.out.println("Vehículo lleno, no puedes agregar el paquete: " + p.getNombre());
		}

	}

	@Override
	public double calcularCoste() {
		double coste = 0;

		for (Paquete p : paquetesCargados) {

			coste += p.getPeso() * COSTE_POR_KG;

			if (p.getPrioridad() == Prioridad.URGENTE) {
				coste += COSTE_URGENTE;

			}
		}
		return coste;
	}
	

}
