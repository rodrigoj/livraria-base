package br.com.casadocodigo.livraria.io;

import java.util.Scanner;

public class EntradaDoTeclado {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite seu nome");
		String nomeDigitado = sc.nextLine();

		System.out.println("Digite sua idade");
		// int idadeDigitada = sc.nextInt();
		String idadeDigitada = sc.nextLine();
		int idade = Integer.parseInt(idadeDigitada);

		System.out.println("Nome: " + nomeDigitado);
		System.out.println("Idade: " + idade);

		sc.close();
	}
}
