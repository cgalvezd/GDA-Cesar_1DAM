package unidad4Practicas.Simulacro2;

public class Producto {
	private static final double IVA = 1.21;
	private static final double RECARGO = 250.50;

	private static int totalProductosCreados = 0;
	private String nombre;
	private double precioBase;
	private Proveedor proveedor;
	private double coste;

	// CONSTRUCTOR COMPLETO
	public Producto(String nombre, double precioBase, Proveedor proveedor) {
		if (precioBase < 0) {
			throw new IllegalArgumentException("Price can not be negative.");
		}
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.proveedor = proveedor;
		this.coste = calcularPrecio();
		totalProductosCreados++;
	}

	// CONSTRUCTOR 2 PARÁMETROS
	public Producto(String nombre, double precioBase) {
		this(nombre, precioBase, new Proveedor());
	}



	// Método calcular precio:
	public double calcularPrecio() {
		double resultado = this.precioBase * IVA;
		if (this.proveedor != null && "GENERIC".equalsIgnoreCase(this.proveedor.getNombre())) {
			resultado += RECARGO;
		}
		return resultado;
	}
	
	public double setPrecioBase(double precioBase) {
		if (precioBase < 0) {
			throw new IllegalArgumentException("Name Cannot be negative");
		}
		return this.precioBase = precioBase;
	}

	public String toString() {
		return "Nombre: " + nombre + "\nPrecio base: " + precioBase + " €" + "\nProveedor: " + proveedor+"\nCoste: "+coste;
	}

	public static void main(String[] args) {
		System.out.println("============== LISTA PRODUCTOS ==============");
		Producto producto = new Producto("Laptop HP", 1000);
		System.out.println(producto);
	}

}