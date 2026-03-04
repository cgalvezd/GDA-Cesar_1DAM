package practicasPersonales;

import java.util.ArrayList;
import java.util.List;

public class VisitRepository {
    
    // Usamos genéricos para garantizar seguridad de tipos
    private final List<Visit> visits;

    public VisitRepository() {
        this.visits = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        // Recorremos el array estático original
        for (String record : Datos.servicios) {
            // Dividimos la cadena usando el separador ';'
            String[] parts = record.split(";");
            
            int id = Integer.parseInt(parts[0]);
            String client = parts[1];
            ServiceType type = ServiceType.valueOf(parts[2].toUpperCase());
            double price = Double.parseDouble(parts[3]);
            
            visits.add(new Visit(id, client, type, price));
        }
    }

    public List<Visit> findAll() {
        return visits;
    }
}