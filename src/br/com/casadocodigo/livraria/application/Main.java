package br.com.casadocodigo.livraria.application;

import java.io.IOException;
import java.util.List;

import br.com.casadocodigo.livraria.Autor;
import br.com.casadocodigo.livraria.dao.ProdutoDAO;
import br.com.casadocodigo.livraria.io.Exportador;
import br.com.casadocodigo.livraria.produtos.Livro;
import br.com.casadocodigo.livraria.produtos.LivroFisico;
import br.com.casadocodigo.livraria.produtos.Produto;

public class Main {

	public static void main(String[] args) {

		List<Produto> produtos = new ProdutoDAO().lista();

		double valorTotal = 0;

		for (Produto produto : produtos) {
			mostraDetalhes(produto);
			valorTotal = produtos.stream().mapToDouble(Produto::getValor).sum();
		}

		Autor autor = new Autor();
		autor.setNome("Guilherme Silveira");

		Livro fisico = new LivroFisico(autor);
		fisico.setNome("Algoritmos em Java");
		fisico.setDescricao("Busca ordenação e análise");
		fisico.setValor(29.90);

		System.out.println(String.format("Você tem R$%.2f em estoque, " + "com um total de %d produtos.\n", valorTotal,
				produtos.size()));

		// new ProdutoDAO().adiciona(fisico);
		new Thread(() -> {
			System.out.println("exportando...");
			dormePorVinteSegundos();
			exportaEmCSV(produtos);
			System.out.println("concluído!");
		}).start();

	}

	private static void mostraDetalhes(Produto produto) {
		System.out.println("Mostrando detalhes do livro ");
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Descrição: " + produto.getDescricao());
		System.out.println("Valor: " + produto.getValor());
		System.out.println("ISBN: " + produto.getIsbn());
		System.out.println("--\n");
	}

	private static void exportaEmCSV(List<Produto> produtos) {
		try {
			new Exportador().paraCSV(produtos);
		} catch (IOException e) {
			System.out.println("Erro ao exportar: " + e);
		}
	}

	private static void dormePorVinteSegundos() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			System.out.println("Ops, ocorreu um erro " + e);
		}
	}
}
