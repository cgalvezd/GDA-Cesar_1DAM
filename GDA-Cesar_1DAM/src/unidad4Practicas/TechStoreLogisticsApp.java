package unidad4Practicas;

import java.util.Arrays;

public class TechStoreLogisticsApp {
	
public static void main(String[] args) {
        
        // 1. Creación de paquetes
        DeliveryPackage contract = new DeliveryPackage("Contrato", 1.0, 0.05, Category.DOCUMENTATION, Priority.NORMAL, false);
        DeliveryPackage fragileVase = new DeliveryPackage("Florero", 2.0, 0.1, Category.ELECTRONICS, Priority.NORMAL, true);
        DeliveryPackage tv = new DeliveryPackage("Televisor", 10.0, 0.5, Category.ELECTRONICS, Priority.NORMAL, true);
        DeliveryPackage urgentBox = new DeliveryPackage("Caja urgente", 3.0, 0.2, Category.TEXTILE, Priority.URGENT, false);

        // 2. Creación de vehículos (Asignando capacidades lógicas por constructor)
        DeliveryVehicle moto = new Motorcycle(15.0, 0.5); 
        DeliveryVehicle van = new Van(800.0, 10.0);       

        // 3. Demostración en Moto
        System.out.println("=== MOTO ===");
        moto.loadPackage(contract);
        moto.loadPackage(fragileVase); // Demuestra rechazo por fragilidad
        
        System.out.println("\n=== FURGONETA ===");
        // Demostración de SOBRECARGA del método loadPackage (usando una lista)
        van.loadPackage(Arrays.asList(tv, urgentBox));

        // 4. Cálculo de costes
        System.out.println("\n=== COSTES ===");
        System.out.println("Coste moto: " + moto.calculateTotalCost() + " €");
        System.out.println("Coste furgoneta: " + van.calculateTotalCost() + " €");
    }
}
