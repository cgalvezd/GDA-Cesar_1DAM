package practicasUnidad6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//Contar líneas
//Una forma moderna de resolverlo es usando java.nio.file.Files.

public class Practica4 {
	public static void main(String[] args) {
		// Path.of("datos.txt")
		// Path es una interfaz que representa la ubicación del archivo en mi sistema
		// Path.of es un método estático que convierte un simple texto ("datos.txt") en
		// un objeto "RUTA" que JAVA entiende perfectamente. Es como darle las
		// coordenadas exactas de dónde está el archivo.
		try {
			//Files.lines es un método que no lee de forma clásica. Sino que, abre un Stream de Strings.
			//No carga todo el archivo en la memoria RAM.
			//Al ser un Stream, permite usar herramientas de programación funcional (como filtros, mapas o, en este caso, contadores).
			long lineas = Files.lines(Path.of("datos.txt")).count();
			System.out.println("Total de líneas: " + lineas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}