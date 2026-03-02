package practicasPersonales;

import java.util.Objects;

public class User {

	// Atributos
	private String email;
	private boolean isActive;

	// Constructor
	public User(String email, boolean isActive) {
		this.email = email;
		this.isActive = isActive;
	}

	// Getter necesario para el repositorio
	public String getEmail() {
		return email;
	}

	// Del enunciado: Dos usuarios son iguales si sus email son idénticos.
	@Override
	public boolean equals(Object otherUser) {
		if (this == otherUser)
			return true;
		if (otherUser == null || getClass() != otherUser.getClass())
			return false;

		User user = (User) otherUser;
		// Solo comparamos el email (ignorando isActive)
		return Objects.equals(email, user.email);
	}

	@Override
	public int hashCode() {
		return email.hashCode();
	}

}