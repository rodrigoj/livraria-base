package br.com.casadocodigo.livraria.produtos;

import br.com.casadocodigo.livraria.Autor;

public class LivroFisico extends Livro implements Promocional {

	public LivroFisico(Autor autor) {
		super(autor);
	}

	public double getTaxaImpressao() {
		return this.getValor() * 0.05;
	}

	public synchronized boolean aplicaDescontoDe(double porcentagem) {

		if (porcentagem > 0.3) {
			return false;
		}

		System.gc();

		synchronized (this) {
			double desconto = getValor() * porcentagem;
			setValor(getValor() - desconto);
			return true;
		}
	}
}