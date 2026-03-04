package practicasPersonales;

import java.util.Objects;

public class Product2 {

	// Atributos
	private String sku;
	private String name;
	private double price;

	// Constructor
	public Product2(String sku, String name, double price) {
		this.sku = sku;
		this.name = name;
		this.price = price;
	}

	// Métodos
	@Override
	public boolean equals(Object otherProduct) {
		if (this == otherProduct)
			return true;

		if (otherProduct == null || getClass() != otherProduct.getClass())
			return false;

		// Casteo
		Product2 product = (Product2) otherProduct;

		return Objects.equals(sku.toLowerCase(), product.sku.toLowerCase());
	}

	@Override
	public int hashCode() {
		return Objects.hash(sku.toLowerCase());
	}

	@Override
	public String toString() {
		return "";
	}

	// Getters
	public String getSku() {
		return sku;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

}
