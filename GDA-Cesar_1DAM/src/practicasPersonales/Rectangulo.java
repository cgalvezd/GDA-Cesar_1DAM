package practicasPersonales;

/**
 * Clase que representa un Rectángulo geométrico definido por su longitud y anchura.
 * 
 * @author Cesar Galvez
 * @version 1.0
 */
public class Rectangulo {
    private double longitud;
    private double anchura;

    /**
     * Crea una instancia de un Rectángulo.
     * 
     * @param longitud El largo del rectángulo.
     * @param anchura  El ancho del rectángulo.
     */
    public Rectangulo(double longitud, double anchura) {
        this.longitud = longitud;
        this.anchura = anchura;
    }

    /**
     * Calcula la superficie total del rectángulo.
     * 
     * @return El área resultante (longitud * anchura).
     */
    public double calcularArea() {
        return longitud * anchura;
    }

    /**
     * Calcula la suma de todos los lados del rectángulo.
     * 
     * @return El perímetro resultante.
     */
    public double calcularPerimetro() {
        return 2 * (longitud + anchura);
    }

    /**
     * @return La longitud actual del rectángulo.
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud La nueva longitud a establecer.
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return La anchura actual del rectángulo.
     */
    public double getAnchura() {
        return anchura;
    }

    /**
     * @param anchura La nueva anchura a establecer.
     */
    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }
}
