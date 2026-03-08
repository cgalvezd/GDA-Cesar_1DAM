package unidad4Practicas;

public class Van extends DeliveryVehicle {

    private static final double COST_PER_KG = 0.6;
    private static final double FIXED_FUEL_SURCHARGE = 5.0;
    private static final double URGENT_SURCHARGE = 2.0;

    public Van(double maxWeight, double maxVolume) {
        super(maxWeight, maxVolume);
    }

    @Override
    public double calculateTotalCost() {
        if (this.loadedPackages.isEmpty()) {
            return 0.0;
        }
        
        double totalCost = FIXED_FUEL_SURCHARGE + (this.currentWeight * COST_PER_KG);
        for (DeliveryPackage pkg : this.loadedPackages) {
            if (pkg.getPriority() == Priority.URGENT) {
                totalCost += URGENT_SURCHARGE;
            }
        }
        return totalCost;
    }
}