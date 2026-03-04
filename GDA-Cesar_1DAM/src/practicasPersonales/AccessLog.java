package practicasPersonales;

import java.util.Objects;

public class AccessLog {

	// Atributos
	private String userId;
	private String terminalId;
	private Long timesttamp;

	// Constructor
	public AccessLog(String userId, String terminalId, Long timesttamp) {
		this.userId = userId;
		this.terminalId = terminalId;
		this.timesttamp = timesttamp;
	}

	// Métodos
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AccessLog that = (AccessLog) o;

		// Comparación doble: Ambos deben coincidir
		return Objects.equals(userId, that.userId) && Objects.equals(terminalId, that.terminalId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, terminalId);
	}

	// Getters

	public String getUserId() {
		return userId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public Long getTimesttamp() {
		return timesttamp;
	}

}