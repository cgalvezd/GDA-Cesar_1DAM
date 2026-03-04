package practicasPersonales;

public class Visit {
    private final int id;
    private final String client;
    private final ServiceType serviceType;
    private final double price;

    public Visit(int id, String client, ServiceType serviceType, double price) {
        this.id = id;
        this.client = client;
        this.serviceType = serviceType;
        this.price = price;
    }

    public int getId() { return id; }
    public String getClient() { return client; }
    public ServiceType getServiceType() { return serviceType; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Visita #%02d | Cliente: %-15s | Servicio: %-11s | Precio: €%.2f", 
                             id, client, serviceType, price);
    }
}