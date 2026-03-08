package unidad4.Practicas.Simulacro3;

public class Order {

	private int number;
	private double total;
	private Carrito sc;
	private Estado estado;

	public Order(int number, double total, Carrito sc, Estado estado) {
		this.number = number;
		this.total = total;
		this.sc = sc;
		this.estado = estado;
	}

	public int getNumber() {
		return number;
	}

	public double getTotal() {
		return total;
	}

	public Carrito getSc() {
		return sc;
	}

	public Estado getEstado() {
		return estado;
	}

	public double procesarPago(double cantidadPagada) {
		double cambio = cantidadPagada - total;
		if (cantidadPagada >= total) {
			this.estado = Estado.PAGADO;
			System.out.println("Nuevo estado: "+this.estado);
		}
		if (cantidadPagada < total) {
			System.out.println("ERROR: Importe incompleto.");
			this.estado = Estado.PENDIENTE;
			throw new IllegalArgumentException("Error de pago. Monto insuficiente");			
		}
		return cambio;
	}

	@Override
	public String toString() {
		return "Número de orden: " + number + "\nTotal: " + total + "\nCapacidad Carrito: " + sc +" artículos"+ "\nEstado de pedido: " + estado;
	}
}