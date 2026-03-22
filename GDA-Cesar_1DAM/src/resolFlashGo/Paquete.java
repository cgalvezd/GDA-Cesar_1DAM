package resolFlashGo;

public class Paquete {

	private String nombre;
	private double peso;
	private double volumen;
	private Categoria categoria;
	private Prioridad prioridad;
	private boolean esFragil;

	public Paquete(String nombre, double peso, double volumen, Categoria categoria, Prioridad prioridad,
			boolean esFragil) {
		if (peso <= 0 || volumen <= 0) {
			throw new IllegalArgumentException("Valores de volumen y peso incorrectos. Deben ser positivos.");
		}

		this.nombre = nombre;
		this.peso = peso;
		this.volumen = volumen;
		this.categoria = categoria;
		this.prioridad = prioridad;
		this.esFragil = esFragil;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPeso() {
		return peso;
	}

	public double getVolumen() {
		return volumen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public boolean isEsFragil() {
		return esFragil;
	}

}
