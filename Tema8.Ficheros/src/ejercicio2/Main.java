package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {

			FileReader rutaFichero = new FileReader("src/ejercicio2/Enteros.txt");

			Scanner sc = new Scanner(rutaFichero);

			double media = 0;
			int suma = 0;
			int cont = 0;

			while (sc.hasNextInt()) {
				suma += sc.nextInt();
				cont++;
			}

			if (cont > 0) {
				media = suma / cont;
				System.out.println("La suma es: " + suma);
				System.out.println("La media es: " + media);
			} else {
				System.out.println("No hay números en el archivo.");
			}

			sc.close();

		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado: " + e.getMessage());
		}

	}

}
