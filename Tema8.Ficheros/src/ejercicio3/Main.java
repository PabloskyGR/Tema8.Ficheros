package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		try {

			FileReader rutaFichero = new FileReader("src/ejercicio3/Alumnos.txt");

			BufferedReader bf = new BufferedReader(rutaFichero);

			double mediaEdad = 0;

			double mediaAltura = 0;

			int cont = 0;

			String linea = bf.readLine();

			String alumnos[];

			while (linea != null) {
				alumnos = linea.split(" ");
				mediaAltura += Double.parseDouble(alumnos[2]);
				mediaEdad += Double.parseDouble(alumnos[1]);
				cont++;
				System.out.println(alumnos[0]);
				linea = bf.readLine();

			}

			if (cont > 0) {
				System.out.println("Media edades: " + mediaEdad / cont);
				System.out.println("Media alturas: " + mediaAltura / cont);
			} else {
				System.out.println("No hay alumnos");
			}

			bf.close();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
