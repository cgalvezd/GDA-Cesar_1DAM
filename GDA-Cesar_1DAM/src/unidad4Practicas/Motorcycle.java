package unidad4Practicas;

public class Motorcycle extends DeliveryVehicle {
	private static final double COST_PER_KG = 0.4;
	private static final double URGENT_SURCHARGE = 1.5;

	public Motorcycle(double maxWeight, double maxVolume) {
		super(maxWeight, maxVolume);
	}

	// Sobreescritura
	@Override
	public void loadPackage(DeliveryPackage pkg) {
		if (pkg.isFragil()) {
			System.out.println("This type of vehicle can upload fragil package.");
			return;
		}
		super.loadPackage(pkg);
	}

	@Override
	public double calculateTotalCost() {
		double totalCost = this.currentWeight * COST_PER_KG;
		for (DeliveryPackage pkg : this.loadedPackages) {
			if (pkg.getPriority() == Priority.URGENT) {
				totalCost += URGENT_SURCHARGE;
			}
		}
		return totalCost;
	}

}
