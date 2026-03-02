package practicasPersonales;

import java.util.HashSet;
import java.util.Set;

public class InventoryService {

	private final Set<Product> uniqueProducts;

	public InventoryService() {
		this.uniqueProducts = new HashSet<>();
	}

	public void registerProduct(Product product) {
		boolean isAdded = uniqueProducts.add(product);
		if (!isAdded) {
			System.out.println("Product with SKU " + product.getSku() + " already exists. Ignored");
		}
	}

	public int getUniqueProductCount() {
		return uniqueProducts.size();
	}
}