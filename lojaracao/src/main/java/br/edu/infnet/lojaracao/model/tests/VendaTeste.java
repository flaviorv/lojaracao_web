package br.edu.infnet.lojaracao.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Ave;
import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.domain.Cliente;
import br.edu.infnet.lojaracao.model.domain.Gato;
import br.edu.infnet.lojaracao.model.domain.Racao;
import br.edu.infnet.lojaracao.model.domain.Venda;


public class VendaTeste {
	public static void main(String[] args) {
		try {

			Cliente cli2 = new Cliente("Mariana Almeida", "154555", "(55)99987-9876");
			List<Racao> racoes = new ArrayList<Racao>();

			

			Cao c2 = new Cao("VaroCaoAmigo", 2519, 9.4f, true, false, "Grande Porte");
			racoes.add(c2);

			Gato g2 = new Gato("VaroGatoArisco", 6549, 98.4f, "Peixe", true, false);
			racoes.add(g2);

			Venda v1 = new Venda();
			v1.setData("17/12/2022");
			v1.setCliente(cli2);
			v1.setEntrega(true);
			v1.setEndereco("Travessa Padre Cláudio, 233, Centro, Sao Paulo - SP");
			v1.setRacoes(racoes);
			Ave av2 = new Ave("RacaoAve2", 234, 24.23f, "Canário", "Mamão", 1.2f);
			racoes.add(av2);

			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
