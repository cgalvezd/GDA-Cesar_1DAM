package practicasPersonales;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        VisitRepository repository = new VisitRepository();
        VisitService service = new VisitService(repository);

        System.out.println("--- F2. LISTADO COMPLETO ---");
        service.printAllVisits();

        System.out.println("\n--- F3. FACTURACIÓN TOTAL ---");
        System.out.printf("Total: €%.2f\n", service.calculateTotalBilling());

        System.out.println("\n--- F4. FILTRADO POR CIRUGÍA ---");
        List<Visit> cirugias = service.filterByServiceType(ServiceType.CIRUGIA);
        for(Visit v : cirugias) System.out.println(v);

        System.out.println("\n--- F5. FACTURACIÓN POR CONSULTA ---");
        System.out.printf("Total Consultas: €%.2f\n", service.calculateBillingByType(ServiceType.CONSULTA));

        System.out.println("\n--- F6. BÚSQUEDA POR CLIENTE (Pedro López) ---");
        List<Visit> pedroVisits = service.findVisitsByClient("Pedro López");
        for(Visit v : pedroVisits) System.out.println(v);
    }
}