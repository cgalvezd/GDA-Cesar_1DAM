package unidad4Practicas.Simulacro2;

public class Proveedor {
	static private int count = 0;

	static final String INITIAL_COD = "PRO";
	private String cod;
	private String nombre;

	public Proveedor() {

		this.cod = "1";
		this.nombre = "GENERIC";
	}

	public Proveedor(String cod, String nombre) {

		this.cod = cod;
		this.nombre = nombre;
	}

	public Proveedor(String nombre) {
		this.cod = INITIAL_COD + " - " + count;
		this.nombre = nombre;
		count++;
	}

	public String getCod() {
		return cod;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Cod Proveedor: " + cod + " || Nombre: " + nombre;
	}
}