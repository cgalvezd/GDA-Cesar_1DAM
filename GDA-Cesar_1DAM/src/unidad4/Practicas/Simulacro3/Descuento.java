package unidad4.Practicas.Simulacro3;

public class Descuento {

	public static double aplicarDescuento(double importe) {
		double precioFinal = importe;
		if (importe > 1000) {
			precioFinal = importe * 0.9;
		}

		return precioFinal;
	}
}