package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {

		try {
			FileReader rutaFichero = new FileReader("src/ejercicio3/Alumnos.txt");

			BufferedReader bf = new BufferedReader(rutaFichero);
			
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

}
