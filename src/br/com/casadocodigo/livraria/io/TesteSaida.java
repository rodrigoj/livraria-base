package br.com.casadocodigo.livraria.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class TesteSaida {
	public static void main(String[] args) throws IOException {

		// OutputStream os = System.out;
		OutputStream os = new FileOutputStream("saida.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write("Testando a escrita em arquivo");
		bw.newLine();
		bw.write("Conteúdo na próxima linha");
		bw.close();

		PrintStream out = new PrintStream("saida2.txt");
		out.println("Testando a escrita em arquivo 2");
		out.println("Conteúdo na próxima linha 2");
		out.close();

		PrintStream ps = System.out;
		ps.println("agora a saída é no console");
		ps.println("Conteúdo na próxima linha");

	}
}
