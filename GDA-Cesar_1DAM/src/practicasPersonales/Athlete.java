package practicasPersonales;

import java.util.Objects;

/**
 * Clase Athlete, representa a un atleta. La identidad del objeto se define por
 * su DNI.
 */
public class Athlete {

	// Atributos
	private String dni;
	private String lastName;
	private int age;

	/**
	 * @param dni      Documento nacional de identidad
	 * @param lastName Appellido completo del atleta
	 * @param age      Edad del atleta
	 */
	public Athlete(String dni, String lastName, int age) {
		this.dni = dni;
		this.lastName = lastName;
		this.age = age;
	}

	/**
	 * Método que compara dos ojetos. 2 Atletas son iguales si tienen el mismo DNI,
	 * ignorando mayúsculas y minúsculas.
	 * 
	 * @param compara si el DNI de un objeto es igual al DNI de otro objeto.
	 * @return{@code true} si los DNI coinciden {@code false} si los DNI no coinciden.
	 */

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
