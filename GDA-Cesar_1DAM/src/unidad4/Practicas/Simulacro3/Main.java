package unidad4.Practicas.Simulacro3;

public class Main {

	public static void main(String[] args) {

		Carrito carrito = new Carrito("Mercadona");
		Order order = new Order(1, 1250, carrito, Estado.PENDIENTE);

		System.out.println(carrito);
		System.out.println();
		System.out.println(order);
		System.out.println();
		
		double nuevoTotal = Descuento.aplicarDescuento(order.getTotal());
		System.out.println(order.procesarPago(1300));
		System.out.println();
		System.out.println("Nuevo precio con descuento "+nuevoTotal);
	}

}
