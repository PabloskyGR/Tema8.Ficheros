package ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BufferedWriter bw = null;

		File archivo = new File("src/ejercicio5/Datos.txt");

		String nombre = "";

		String datos = "";

		int edad = 0;

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.getMessage();
			}
		}

		try {
			bw = new BufferedWriter(new FileWriter(archivo, true));

			System.out.println("Dime tu nombre:");
			nombre = sc.next();
			sc.nextLine();

			System.out.println("Dime tu edad:");
			edad = sc.nextInt();

			datos += "Nombre: " + nombre + " Edad: " + edad;

			bw.write(datos);
			bw.newLine();

		} catch (IOException e) {
			e.getMessage();

		} catch (InputMismatchException e) {
			e.getMessage();
		} finally {
			try {
				bw.flush();
				bw.close();
				sc.close();
			} catch (IOException e) {
				e.getMessage();

			}
		}

	}

}
