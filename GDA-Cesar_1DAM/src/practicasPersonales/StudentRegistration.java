package practicasPersonales;

import java.util.Objects;

public class StudentRegistration {

	// Atributos
	private String registrationId;
	private String fullName;
	private double accessGrade;

	// Constructor
	public StudentRegistration(String registrationId, String fullName, double accessGrade) {
		this.registrationId = registrationId;
		this.fullName = fullName;
		this.accessGrade = accessGrade;
	}

	// Getter
	public String getRegistrationId() {
		return registrationId;
	}

	// Comparar
	@Override
	public boolean equals(Object otherUser) {
		if (this == otherUser)
			return true;
		if (otherUser == null || getClass() != otherUser.getClass())
			return false;

		// Cast
		StudentRegistration studentRegistration = (StudentRegistration) otherUser;
		return Objects.equals(registrationId, studentRegistration.registrationId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(registrationId);
	}
}