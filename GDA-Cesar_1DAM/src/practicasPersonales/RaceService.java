package practicasPersonales;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RaceService {

	// Método
	public List<Athlete> getCleanRegistry(List<Athlete> metodo1) {
		// 1. Eliminamos objetos duplicados
		Set<Athlete> distinctAthlete = new HashSet<>(metodo1);

		// 2. Los resultados obtenidos de la lista anterior, los ordenamos.
		List<Athlete> sortedList = new ArrayList<>(distinctAthlete);

		// 3 Ordenación por edad (De Menor a mayor)
		sortedList.sort(Comparator.comparing(Athlete::getAge));

		return sortedList;

	}

}
