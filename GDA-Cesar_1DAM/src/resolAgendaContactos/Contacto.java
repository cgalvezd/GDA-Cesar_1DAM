package resolAgendaContactos;

public class Contacto {

	// ATRIBUTOS
	private String nombre;
	private String telefono;
	private String email;

	// CONSTRUCTOR
	public Contacto(String nombre, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	// GETTERS
	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return nombre + ";" + telefono + ";" + email;
	}
}