package br.com.casadocodigo.livraria.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TesteEntrada {
	public static void main(String[] args) {

		try {

			Scanner sc = new Scanner(new File("teste.txt"));
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

			sc.close();

			InputStream is = System.in;
			// InputStream is = new FileInputStream("teste.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);

			String linha = reader.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = reader.readLine();
			}

			reader.close();

		} catch (IOException e) {
			System.out.println("Erro ao tentar ler o arquivo " + e);
		}
	}
}
