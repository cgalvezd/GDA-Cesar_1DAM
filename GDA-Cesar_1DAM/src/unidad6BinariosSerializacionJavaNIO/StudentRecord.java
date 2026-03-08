package unidad6BinariosSerializacionJavaNIO;

import java.io.*;
import java.nio.file.*;
import java.util.List;

// 1. La clase DEBE implementar Serializable para poder guardarse
class StudentRecord implements Serializable {
	private String name;
	private double grade;

	public StudentRecord(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}

	public void printInfo() {
		System.out.println("Student: " + name + " | Grade: " + grade);
	}

	public class ExamBinaryNIO {
		public static void main(String[] args) {

			// --- PARTE 1: NIO (Comprobación y lectura rápida) ---
			Path textPath = Paths.get("students_list.txt"); // Usamos Paths en lugar de new File()

			if (Files.exists(textPath)) {
				try {
					// NIO permite leer todas las líneas de golpe en una Lista
					List<String> lines = Files.readAllLines(textPath);
					System.out.println("Lines read using NIO: " + lines.size());
				} catch (IOException e) {
					System.err.println("NIO Error: " + e.getMessage());
				}
			}

			// --- PARTE 2: Serialización (Guardar y Leer Objetos) ---
			String dataFile = "student_data.dat";
			StudentRecord student = new StudentRecord("Cesar", 9.5);

			// ESCRITURA: ObjectOutputStream envuelve a FileOutputStream
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
				oos.writeObject(student); // Escribimos el objeto entero
				System.out.println("Object serialized successfully.");
			} catch (IOException e) {
				System.err.println("Serialization error: " + e.getMessage());
			}

			// LECTURA: ObjectInputStream envuelve a FileInputStream
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile))) {
				// OBLIGATORIO: Hacer casting (StudentRecord) al leer el objeto
				StudentRecord recoveredStudent = (StudentRecord) ois.readObject();
				System.out.println("Object deserialized:");
				recoveredStudent.printInfo();
			} catch (IOException | ClassNotFoundException e) {
				// ClassNotFoundException es obligatoria atraparla al leer objetos
				System.err.println("Deserialization error: " + e.getMessage());
			}
		}
	}
}