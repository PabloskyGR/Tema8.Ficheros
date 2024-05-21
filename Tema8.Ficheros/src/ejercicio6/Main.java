package ejercicio6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = null;

		BufferedWriter bw = null;

		ArrayList<Integer> lista = new ArrayList<Integer>();

		File archivo = new File("src/ejercicio6/Ordenados.txt");

		int numero;

		try {
			sc = new Scanner(new FileReader("src/ejercicio6/Desordenados.txt"));

			while (sc.hasNextInt()) {

				numero = sc.nextInt();

				lista.add(numero);

			}

			Collections.sort(lista);

			if (!archivo.exists()) {
				try {
					archivo.createNewFile();
				} catch (IOException e) {
					e.getMessage();
				}
			}

			try {
				bw = new BufferedWriter(new FileWriter(archivo));

				for (int num : lista) {
					bw.write(String.valueOf(num));
					bw.newLine();
				}
			} catch (IOException e) {
				e.getMessage();
			}

		} catch (FileNotFoundException e) {
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
