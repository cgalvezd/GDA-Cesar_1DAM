package practicasPersonales;

import java.util.Objects;

public class Athlete {

	// Atributos
	private String dni;
	private String lastName;
	private int age;

	// Constructor
	public Athlete(String dni, String lastName, int age) {
		this.dni = dni;
		this.lastName = lastName;
		this.age = age;
	}

	// Métodos
	// 2 atletas son el mismo si tienen el mismo DNI (Sin importar mayúsculas y
	// minúsculas)
	@Override
	public boolean equals(Object otherAthlete) {
		if (this == otherAthlete)
			return true;
		if (otherAthlete == null || getClass() != otherAthlete.getClass())
			return false;

		Athlete athlete = (Athlete) otherAthlete;
		return Objects.equals(dni.toLowerCase(), athlete.dni.toLowerCase());
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni.toLowerCase());
	}

	// Getters
	public String getDni() {
		return dni;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

}
