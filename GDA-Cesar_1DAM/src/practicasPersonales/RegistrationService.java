package practicasPersonales;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class RegistrationService {

	public Set<StudentRegistration> filterDuplicates(List<StudentRegistration> rawData) {
		// Al instanciar un HashSet pasando la lista, la arauitectura de Java
		// usa internamente hashCode() y equals() para filtrar los duplicados.
		return new HashSet<>(rawData);

	}
}