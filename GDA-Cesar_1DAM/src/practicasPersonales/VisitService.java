package practicasPersonales;

import java.util.ArrayList;
import java.util.List;

public class VisitService {

    private final VisitRepository repository;

    public VisitService(VisitRepository repository) {
        this.repository = repository;
    }

    // F2. Listado completo
    public void printAllVisits() {
        for (Visit visit : repository.findAll()) {
            System.out.println(visit);
        }
    }

    // F3. Facturación total
    public double calculateTotalBilling() {
        double total = 0;
        for (Visit visit : repository.findAll()) {
            total += visit.getPrice();
        }
        return total;
    }

    // F4. Filtrado por tipo de servicio
    public List<Visit> filterByServiceType(ServiceType type) {
        List<Visit> filtered = new ArrayList<>();
        for (Visit visit : repository.findAll()) {
            if (visit.getServiceType() == type) {
                filtered.add(visit);
            }
        }
        return filtered;
    }

    // F5. Facturación por tipo de servicio
    public double calculateBillingByType(ServiceType type) {
        double total = 0;
        for (Visit visit : filterByServiceType(type)) {
            total += visit.getPrice();
        }
        return total;
    }

    // F6. Búsqueda por cliente
    public List<Visit> findVisitsByClient(String clientName) {
        List<Visit> clientVisits = new ArrayList<>();
        for (Visit visit : repository.findAll()) {
            // Ignoramos mayúsculas/minúsculas para una búsqueda más robusta
            if (visit.getClient().equalsIgnoreCase(clientName)) {
                clientVisits.add(visit);
            }
        }
        return clientVisits;
    }
}