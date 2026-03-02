package practicasPersonales;

public class Product {
	
	private String sku;
	private String name;
	private double price;

	public Product(String sku, String name, double price) {
		this.sku = sku;
		this.name = name;
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Product product = (Product) obj;
		return sku.equals(product.sku);
	}

	@Override
	public int hashCode() {
		return sku.hashCode();
	}

}