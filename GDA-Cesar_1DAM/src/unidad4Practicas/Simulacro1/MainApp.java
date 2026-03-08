package unidad4Practicas.Simulacro1;

public class MainApp {

	public static void main(String[] args) {
		Direccion direccion = new Direccion("Calle Ciclamen 2", "Navalmoral de la Mata", "10300", ZonaEnvio.LOCAL);

		Cliente cliente = new Cliente(1, "Cesar", "cesar@correo.com", direccion);
		
		System.out.println("========== CLIENTES REGISTRADOS  ==========\n");

		System.out.println(cliente.toString());
	}

}
