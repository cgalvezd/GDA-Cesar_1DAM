package practicasUnidad6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EfficientExamIO {

	/**
	 * @param inputFile
	 * @param outputFile
	 */
	public static void processExamFiles(String inputFile, String outputFile) {

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			String line;
			int lineNumber = 1;

			while ((line = reader.readLine()) != null) {
				// Procesamos la línea (ejemplo: la pasamos a mayúsculas)
				String processedLine = String.format("Line %d: %s", lineNumber, line.toUpperCase());
				writer.write(processedLine);
				writer.newLine();
				lineNumber++;
			}
		} catch (IOException e) {
			System.err.println("Critical I/O Error processing files: " + e.getMessage());

		}

	}

	public static void main(String[] args) {

	}
}