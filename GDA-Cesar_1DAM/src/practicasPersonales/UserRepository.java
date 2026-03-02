package practicasPersonales;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

	private final Map<String, User> database;

	public UserRepository() {
		this.database = new HashMap<>();
	}

	public void saveUser(User user) {
		// .put inserta si no existe, o reemplaza_actualiza
		database.put(user.getEmail(), user);
	}

	public User findUserByEmail(String email) {
		User user = database.get(email);

		if (user == null) {
			throw new IllegalArgumentException("Usuario con email " + email + " no encontrado");
		}
		return user;
	}

}
