package br.com.casadocodigo.livraria.threads;

import java.io.IOException;
import java.util.List;

import br.com.casadocodigo.livraria.io.Exportador;
import br.com.casadocodigo.livraria.produtos.Produto;

public class ExportadorDeCSV implements Runnable {

	@Override
	public void run() {
		System.out.println("Rodando em paralelo!");
	}

	public void exportaEmCSV(List<Produto> produtos) {
		try {
			new Exportador().paraCSV(produtos);
		} catch (IOException e) {
			System.out.println("Erro ao exportar: " + e);
		}
	}
}
