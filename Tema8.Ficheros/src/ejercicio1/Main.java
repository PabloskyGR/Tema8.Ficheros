package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		try {

			FileReader rutaFichero = new FileReader("src/ejercicio1/NumerosReales.txt");

			BufferedReader bf = new BufferedReader(rutaFichero);

			double media = 0;
			int suma = 0;
			int cont = 0;
			String linea = bf.readLine();

			while (linea != null) {
				suma += Integer.parseInt(linea);
				cont++;
				linea = bf.readLine();
			}

			if (cont > 0) {
				media = (double) suma / cont;
				System.out.println("La suma es: " + suma);
				System.out.println("La media es: " + media);
			} else {
				System.out.println("No hay números en el archivo.");
			}

			bf.close();

		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}

	}

}
