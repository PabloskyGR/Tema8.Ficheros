package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ejercicio4/Texto.txt"));

			Scanner sc = new Scanner(System.in);

			String linea = "";

			while (!linea.toLowerCase().equals("fin")) {

				linea = sc.next();
				sc.nextLine();

				if (!linea.toLowerCase().equals("fin")) {
					bw.write(linea);
					bw.newLine();
				}
			}

			bw.flush();
			bw.close();
			sc.close();

		} catch (IOException e) {
			e.getMessage();
		}

	}

}
