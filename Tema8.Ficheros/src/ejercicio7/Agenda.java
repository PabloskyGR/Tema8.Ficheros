package ejercicio7;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Agenda {

	public static void main(String[] args) {

		TreeMap<String, Long> lista = new TreeMap<String, Long>();

		long telefono = 0;
		int opc = 0;
		String nombre = null;
		String rutaFichero = "src/ejercicio7/Agenda.txt";
		String[] contactos;

		Scanner sc = null;
		BufferedWriter bw = null;

		try {

			sc = new Scanner(new FileReader(rutaFichero));

			while (sc.hasNextLine()) {

				contactos = sc.nextLine().split(" ");
				lista.put(contactos[0], Long.valueOf(contactos[1]));
			}

		} catch (FileNotFoundException e) {
			e.getMessage();
		}

		try {
			bw = new BufferedWriter(new FileWriter(rutaFichero));
			sc = new Scanner(System.in);

			do {
				menu();
				opc = sc.nextInt();
				sc.nextLine();

				switch (opc) {
				case 1:

					if (lista.size() < 20) {
						System.out.println("Dime el nombre del contacto: ");
						nombre = sc.next();
						sc.nextLine();
						System.out.println("Dime el número de teléfono:");
						telefono = sc.nextLong();

						if (!lista.containsValue(telefono)) {
							lista.put(nombre, Long.valueOf(telefono));
							System.out.println("Contacto añadido");
							System.out.println();
						} else {
							System.err.println("Error: Contacto existente");
							System.out.println();
						}
					} else {
						System.err.println("Error: Agenda llena");
						System.out.println();
					}
					break;
				case 2:
					System.out.println("Dime el nombre del contacto para buscar: ");
					nombre = sc.next();
					sc.nextLine();

					if (lista.containsKey(nombre)) {
						System.out.print("El teléfono del contacto " + nombre + " es: ");
						System.out.println(lista.get(nombre));
						System.out.println();
					} else {
						System.err.println("El contacto no se encuentra");
						System.out.println();
					}

					break;
				case 3:
					System.out.println("CONTACTOS:");
					for (Entry<String, Long> values : lista.entrySet()) {
						System.out.println("- Nombre: " + values.getKey());
						System.out.println("  Número de teléfono: " + values.getValue());
					}
					break;
				case 4:
					for (Entry<String, Long> values : lista.entrySet()) {
						bw.write(values.getKey() + " " + values.getValue());
						bw.newLine();
					}

					System.out.println("Saliendo del programa...");

					break;
				default:
					System.err.println("Error: Opción no válida");
				}

			} while (opc != 4);

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				bw.flush();
				bw.close();
				sc.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

	}

	private static void menu() {
		System.out.println("Seleccione una de las siguientes opciones: ");
		System.out.println("1. Nuevo contacto ");
		System.out.println("2. Buscar por nombre ");
		System.out.println("3. Mostrar todos ");
		System.out.println("4. Salir");
	}

}
