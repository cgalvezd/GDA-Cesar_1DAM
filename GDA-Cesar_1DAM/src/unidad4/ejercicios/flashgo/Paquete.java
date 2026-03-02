package unidad4.ejercicios.flashgo;

public class Paquete {

	// Atributos
	private String nombre;
	private double peso;
	private int volumen;

	private String[] categoria = { "ELECTRONICA", "ALIMENTACION", "DOCUMENTACION", "TEXTIL" };

	private String[] prioridad = { "NORMAL", "URGENTE" };
	private boolean isFragil;

	// Constructor
	public Paquete(String nombre, double peso, int volumen, String categoria, String prioridad) {
		this.nombre = nombre;
		this.peso = peso;
		this.volumen = volumen;
		
		//Determinar si es fragil o no.
		boolean paquetePrioritario() {
			for (int i = 0; i < categoria.length; i++) {
				if(categoria.equalsIgnoreCase("ELECTRONICA" || "ALIMENTACION")) {
					return this.isFragil = true;
				}else {
					return this.isFragil = false;
				}
			}
			return this.isFragil;
		}
		
		this.isFragil = paquetePrioritario();
	}

	// Método apra ver si es fragil o no

	// Métodos
	public String toString() {
		return "Nombre: " + nombre + " | Peso: " + peso + " | Volumen: " + volumen + " | Categoria: " + categoria
				+ " | Prioridad: " + prioridad + " | Fragil: " + isFragil;
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public double getPeso() {
		return peso;
	}

	public int getVolumen() {
		return volumen;
	}

	public static void main(String[] args) {
		Paquete paquete = new Paquete("Laptop", 12.5, 3, "ELECTRONICA", "URGENTE");

		System.out.println(paquete.toString());

	}

}


