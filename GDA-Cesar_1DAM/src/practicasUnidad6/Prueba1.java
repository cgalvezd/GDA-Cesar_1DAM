package practicasUnidad6;

import java.io.File;

public class Prueba1 {

	public static void main(String[] args) {
		
		File file = new File("texto.txt");
		
		if (file.exists()) {
			System.out.println("File already exist.");
			return;
		}
		
		System.out.println("Cuantos artículos vas a ingresar");

	}

}
