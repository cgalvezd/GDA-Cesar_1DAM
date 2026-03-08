package unidad4Practicas.Simulacro1;

public class Cliente {
	private static final double PRECIO_BASE = 5.0;
	private static final double PRECIO_NACIONAL = 10.0;
	private static final double PRECIO_INTERNACIONAL = 25.0;

	// Atributos
	private int ID;
	private String name;
	private String email;
	private Direccion direccion;

	private double costoEnvio;

	public Cliente(int id, String name, String email, Direccion direccion) {
		this.ID = id;
		this.name = name;
		setEmail(email);
		this.direccion = direccion;
		this.costoEnvio = costoEnvio();
	}

	// Métodos
	// Calcular costo de envio.
	public double costoEnvio() {

		if (this.direccion.getZonaEnvio() == ZonaEnvio.LOCAL) {
			costoEnvio = PRECIO_BASE;
		}

		if (this.direccion.getZonaEnvio() == ZonaEnvio.INTERNACIONAL) {
			costoEnvio = PRECIO_BASE + PRECIO_INTERNACIONAL;
		}
		if (this.direccion.getZonaEnvio() == ZonaEnvio.NACIONAL) {
			costoEnvio = PRECIO_BASE + PRECIO_NACIONAL;
		}
		return costoEnvio;

	}

	// Getters
	public int getID() {
		return ID;
	}

	public double getCostoEnvio() {
		return costoEnvio;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	// Setters
	public void setEmail(String email) {
		if (email.trim().isEmpty()) {
			throw new IllegalArgumentException("Field email con not be create because is empty.");
		}

		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente:" + "\nID=" + ID + "\nName=" + name + "\nEmail=" + email + "\nDirección:\n" + direccion
				+ "\nCosto envio: " + costoEnvio;
	}
}
