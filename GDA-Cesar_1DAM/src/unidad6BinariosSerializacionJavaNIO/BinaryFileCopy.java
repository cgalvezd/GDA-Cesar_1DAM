package unidad6BinariosSerializacionJavaNIO;

import java.io.*;

public class BinaryFileCopy {
    public static void main(String[] args) {
        
        // Declaramos los flujos dentro del try-with-resources para cierre automático [cite: 391, 546]
        try (
            // FileInputStream lee el archivo original byte a byte [cite: 510]
            // BufferedInputStream lo envuelve para leer en bloques de memoria, mejorando el rendimiento [cite: 547, 561]
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("origen.pdf"));
            
            // FileOutputStream crea o sobrescribe el archivo de destino [cite: 510]
            // BufferedOutputStream lo envuelve para escribir en bloques [cite: 548]
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("copia.pdf"))
        ) {
            // Creamos un array de bytes que actuará como nuestro "camión de transporte" de datos (1KB a la vez) [cite: 551]
            byte[] buffer = new byte[1024];
            
            // Variable para almacenar cuántos bytes reales hemos leído en cada viaje [cite: 552]
            int bytesRead;
            
            // El método read(buffer) llena el array y devuelve la cantidad de bytes leídos. 
            // Devuelve -1 si llegó al final del archivo [cite: 524, 553]
            while ((bytesRead = in.read(buffer)) != -1) {
                
                // Escribimos en el archivo de destino solo la cantidad exacta de bytes que acabamos de leer [cite: 555]
                out.write(buffer, 0, bytesRead);
            }
            
            // Imprimimos mensaje de éxito en consola
            System.out.println("Binary file copied successfully.");

        } catch (IOException e) {
            // Capturamos cualquier error (archivo no existe, sin permisos, etc.) [cite: 558]
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}