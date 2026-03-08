package unidad4Practicas.Simulacro2;

public class Main {
	public static void main(String[] args) {
		// Proveedor genérico.
		Proveedor proveedor = new Proveedor();

		Proveedor proveedor1 = new Proveedor("PRO-01", "Panasonic");
		Proveedor proveedor2 = new Proveedor("PRO-02", "Samsung Electronics");
		Proveedor proveedor3 = new Proveedor("Apple Inc");
		Proveedor proveedor4 = new Proveedor("Xiaomi Inc");
		Proveedor proveedor5 = new Proveedor("Huawei Inc");
		Proveedor proveedor6 = new Proveedor("Samsung Inc");

		System.out.println("===================== LISTA DE PROVEEDORES =====================");
		System.out.println(proveedor);

		System.out.println();

		System.out.println(proveedor1);
		System.out.println(proveedor2);

		System.out.println();

		System.out.println(proveedor3);
		System.out.println(proveedor4);
		System.out.println(proveedor5);
		System.out.println(proveedor6);

		System.out.println("\n===================== LISTA DE PRODUCTOS =====================");
		Producto producto = new Producto("HP GAMING", 1580.90, proveedor1);
		Producto producto2 = new Producto("Mac Mini M4", 1499);
		Producto producto3 = new Producto("HP OMION", 1599.55, proveedor2);
		Producto producto4 = new Producto("Iphone 17 PRO MAX", 1799.95);
		Producto producto5 = new Producto("MacBook Pro with M4 / 1 TB SSD", 2225.50);
		Producto producto6 = new Producto("Crew Dragon", 199_999.50);

		System.out.println(producto);
		System.out.println();
		System.out.println(producto2);
		System.out.println();

		System.out.println(producto3);
		System.out.println();

		System.out.println(producto4);
		System.out.println();

		System.out.println(producto5);
		System.out.println();

		System.out.println(producto6);

	}
}