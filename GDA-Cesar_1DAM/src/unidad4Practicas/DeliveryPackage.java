package unidad4Practicas;

import java.util.List;

public class DeliveryPackage {

	// Atributos
	private final String name;
	private final double weight;
	private final double volume;
	private final Category category;
	private final Priority priority;
	private final boolean isFragil;
	private List<DeliveryPackage> listPackage;

	public DeliveryPackage(String name, double weight, double volume, Category category, Priority priority, boolean isFragil) {

		this.name = name;
		this.weight = weight;
		this.volume = volume;
		this.category = category;
		this.priority = priority;
		this.isFragil = isFragil;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolume() {
		return volume;
	}

	public Category getCategory() {
		return category;
	}

	public Priority getPriority() {
		return priority;
	}

	public boolean isFragil() {
		return isFragil;
	}

	public List<DeliveryPackage> getListPackage() {
		return listPackage;
	}
}
