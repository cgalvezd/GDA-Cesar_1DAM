package unidad6BinariosSerializacionJavaNIO;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonDataProcessor {

    public static void main(String[] args) {
        
        // Creamos un arreglo JSON vacío para almacenar a los estudiantes [cite: 1158]
        JSONArray studentsArray = new JSONArray();

        // Creamos el primer estudiante como un objeto JSON y añadimos sus pares clave-valor [cite: 1159-1161]
        JSONObject student1 = new JSONObject();
        student1.put("name", "Ana");
        student1.put("grade", 8.5);

        // Creamos el segundo estudiante [cite: 1162-1164]
        JSONObject student2 = new JSONObject();
        student2.put("name", "Carlos");
        student2.put("grade", 4.2); 

        // Añadimos los objetos individuales al arreglo principal [cite: 1165-1166]
        studentsArray.put(student1);
        studentsArray.put(student2);

        // Imprimimos el JSON generado en consola para verificar su estructura [cite: 1167]
        System.out.println("Generated JSON payload:");
        System.out.println(studentsArray.toString(2)); // El '2' tabula el JSON para que sea legible

        System.out.println("\n--- Processing Data ---");
        
        // Llamamos al método encargado de la lógica de negocio pasando el JSONArray
        processStudentData(studentsArray);
    }

    /**
     * Procesa un JSONArray para calcular estadísticas básicas (media y conteo de aprobados).
     * @param students El arreglo JSON con los datos en crudo de los estudiantes.
     */
    public static void processStudentData(JSONArray students) {
        double totalSum = 0;
        int passedCount = 0;

        // Recorremos el arreglo JSON usando su método length() [cite: 1176-1178]
        for (int i = 0; i < students.length(); i++) {
            
            // Extraemos el objeto JSON en la posición del índice actual 'i' [cite: 1179]
            JSONObject currentStudent = students.getJSONObject(i);
            
            // Extraemos los valores concretos usando los métodos tipados getDouble y getString 
            double grade = currentStudent.getDouble("grade");
            String name = currentStudent.getString("name");

            // Sumamos la nota al acumulador para el cálculo posterior de la media [cite: 1180]
            totalSum += grade;

            // Filtramos la información: Si la nota es mayor o igual a 5, el estudiante aprueba [cite: 1184-1186]
            if (grade >= 5.0) {
                passedCount++;
                System.out.println(name + " has PASSED with a grade of " + grade);
            } else {
                System.out.println(name + " has FAILED with a grade of " + grade);
            }
        }

        // Calculamos la media final dividiendo la suma total entre la longitud del arreglo [cite: 1181]
        double average = totalSum / students.length();
        
        // Imprimimos los resultados agregados finales por consola [cite: 1182, 1188]
        System.out.println("-------------------------");
        System.out.println("Class Average: " + average);
        System.out.println("Total Passed: " + passedCount);
    }
}