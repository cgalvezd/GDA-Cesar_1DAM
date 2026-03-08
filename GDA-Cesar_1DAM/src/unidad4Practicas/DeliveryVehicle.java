package unidad4Practicas;

import java.util.ArrayList;
import java.util.List;

public abstract class DeliveryVehicle {
	protected final double maxWeight;
	protected final double maxVolume;
	protected double currentWeight;
	protected double currentVolume;
	protected final List<DeliveryPackage> loadedPackages;

	public DeliveryVehicle(double maxWeight, double maxVolume) {
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
		this.currentWeight = 0.0;
		this.currentVolume = 0.0;
		this.loadedPackages = new ArrayList<>();
	}

	// Método de carga
	public void loadPackage(DeliveryPackage pkg) {
		if (currentWeight + pkg.getWeight() > maxWeight) {
			System.out.println("There is not enough capacity for " + pkg.getName() + ".");
			return;
		}
		if (currentVolume + pkg.getVolume() > maxVolume) {
			System.out.println("There is not enought volume for " + pkg.getName());
		}
		this.currentWeight += pkg.getWeight();
		this.currentVolume += pkg.getVolume();
		this.loadedPackages.add(pkg);
		System.out.println("Package loaded successfully " + pkg.getName());
	}
	
	//Método que permite cargar más de un paquete a la vez
	public void loadPackage(List<DeliveryPackage> packages) {
		for (DeliveryPackage pkg : packages) {
			this.loadPackage(pkg);
		}
	}
	
	public abstract double calculateTotalCost();
}