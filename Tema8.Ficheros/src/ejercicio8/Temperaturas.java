package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Temperaturas {

	public static void main(String[] args) {

		int opc;
		double temperaturaMin;
		double temperaturaMax;
		double temperaturaMinT = Double.MAX_VALUE;
		double temperaturaMaxT = Double.MIN_VALUE;
		String[] datos;
		String linea = "";
		String fecha;
		String rutaFichero = "src/ejercicio8/Registro.txt";
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = null;
		BufferedReader br = null;

		try {
			bw = new BufferedWriter(new FileWriter(rutaFichero, true));

			do {
				menu();
				opc = sc.nextInt();
				sc.nextLine();

				switch (opc) {
				case 1:

					System.out.println("Dime la fecha (yyyy/MM/dd):");
					fecha = sc.nextLine();

					System.out.println("Dime la temperatura mínima:");
					temperaturaMin = sc.nextDouble();
					sc.nextLine();

					System.out.println("Dime la temperatura máxima:");
					temperaturaMax = sc.nextDouble();
					sc.nextLine();

					bw.write(fecha + "," + temperaturaMax + "," + temperaturaMin);
					bw.newLine();

					bw.flush();

					break;
				case 2:
					br = new BufferedReader(new FileReader(rutaFichero));
					br.readLine();
					linea = br.readLine();
					while (linea != null) {
						datos = linea.split(",");
						System.out.println("Fecha: " + datos[0]);

						temperaturaMax = Double.parseDouble(datos[1]);
						temperaturaMin = Double.parseDouble(datos[2]);

						System.out.println("Temperatura máxima: " + temperaturaMax);
						System.out.println("Temperatura mínima: " + temperaturaMin);
						System.out.println();

						if (temperaturaMaxT < temperaturaMax) {
							temperaturaMaxT = temperaturaMax;
						}
						if (temperaturaMinT > temperaturaMin) {
							temperaturaMinT = temperaturaMin;
						}

						linea = br.readLine();
					}
					System.out.println("-------------------------------------------");
					System.out.println("Temperatura máxima total: " + temperaturaMaxT);
					System.out.println("Temperatura mínima total: " + temperaturaMinT);
					System.out.println("-------------------------------------------");
					break;
				}

			} while (opc != 3);

		} catch (IOException e) {
			e.getMessage();
		} finally {
			if (bw != null) {
				try {
					bw.close();
					br.close();
					sc.close();
				} catch (IOException e) {
					e.getMessage();
				}
			}
		}

	}

	public static void menu() {
		System.out.println("1. Registra nueva temperatura.");
		System.out.println("2. Mostrar historial de registros.");
		System.out.println("3. Salir.");

	}

}
