package unidad4Practicas.Simulacro1;

public class Direccion {

	// Atributos
	private String calle;
	private String ciudad;
	private String codigoPostal;
	private ZonaEnvio zonaEnvio;

	// Constructor
	public Direccion(String calle, String ciudad, String codigoPostal, ZonaEnvio zonaEnvio) {
		this.calle = calle;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.zonaEnvio = zonaEnvio;
	}

	public String getCalle() {
		return calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public ZonaEnvio getZonaEnvio() {
		return zonaEnvio;
	}

	public String toString() {
		return "Calle: " + this.calle + "\nCiudad: " + this.ciudad + "\nCodigo Postal: " + this.codigoPostal
				+ "\nZona Envío: " + this.zonaEnvio;
	}
}
