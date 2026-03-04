package practicasPersonales;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WarehouseService {

	public List<Product2> getUniqueStockSorted(List<Product2> incomingShipment) {
		//1. Eliminar duplicados: Pasamos la lista a un set.
		//Gracias al equalas y el hashCode(), los SKU repetidos se eliminanm
		Set<Product2> distinctProducts = new HashSet<>(incomingShipment);
		
		//2. Convertimos de nuevo a Lista: El Set no se puede ordenar,
		//Así que metemos los elementos limpios en una nueva ArrayList.
		List<Product2> sortedList = new ArrayList<>(distinctProducts);
		
		//3. Ordenación: Utilizo Sort con un Comparator
		//Esto extrae el nombre para comparar alfabéticamente.
		sortedList.sort(Comparator.comparing(Product2::getName));
		return sortedList;
	}
}