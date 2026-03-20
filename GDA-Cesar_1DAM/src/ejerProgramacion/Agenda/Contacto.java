package ejerProgramacion.Agenda;


public class Contacto {

    // 🔹 Atributos (encapsulación)
    private String nombre;
    private String telefono;
    private String email;

    // 🔹 Constructor
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // 🔹 Getters (no setters → diseño más seguro)
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    // 🔹 Serialización a CSV (CLAVE para ficheros)
    @Override
    public String toString() {
        return nombre + ";" + telefono + ";" + email;
    }
}