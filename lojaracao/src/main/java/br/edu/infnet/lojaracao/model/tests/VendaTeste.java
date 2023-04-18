package br.edu.infnet.lojaracao.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Ave;
import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.domain.Cliente;
import br.edu.infnet.lojaracao.model.domain.Endereco;
import br.edu.infnet.lojaracao.model.domain.Gato;
import br.edu.infnet.lojaracao.model.domain.Racao;
import br.edu.infnet.lojaracao.model.domain.Venda;
import br.edu.infnet.lojaracao.model.exceptions.ClienteNaoAtribuidoException;
import br.edu.infnet.lojaracao.model.exceptions.DataNaoAtribuidaException;
import br.edu.infnet.lojaracao.model.exceptions.RacaoNaoAtribuidaException;

public class VendaTeste {
	public static void main(String[] args) {
		try {

			Endereco e = new Endereco();
			e.setCep("36684020");
			e.setLogradouro("Rua Travessa Padre Cláudio");
			e.setComplemento("263");
			e.setBairro("Caxangá");
			e.setLocalidade("São José dos Pinhais");
			e.setUf("SC");

			Cliente cli = new Cliente("Mariana Almeida", "154555", "(55)99987-9876");
			cli.setEndereco(e);
			List<Racao> racoes = new ArrayList<Racao>();

			Cao c = new Cao("VaroCaoAmigo", 2519, 9.4f, true, false, "Grande Porte");
			racoes.add(c);

			Gato g = new Gato("VaroGatoArisco", 6549, 98.4f, "Peixe", true, false);
			racoes.add(g);

			try {
				Venda v = new Venda("10/10/2020", false, 30, cli, racoes);
				System.out.println(v);
			} catch (DataNaoAtribuidaException | ClienteNaoAtribuidoException | RacaoNaoAtribuidaException e1) {
				System.out.println(e1.getMessage());
			}

			try {
				Venda v1 = new Venda(null, true, 60, cli, racoes);
				System.out.println(v1);
			} catch (DataNaoAtribuidaException | ClienteNaoAtribuidoException | RacaoNaoAtribuidaException e2) {
				System.out.println(e2.getMessage());
			}

			Ave av2 = new Ave("RacaoAve2", 234, 24.23f, "Canário", "Mamão", 1.2f);
			racoes.add(av2);

			try {
				Venda v2 = new Venda("10/10/2020", false, 0, cli, racoes);
				System.out.println(v2);
			} catch (DataNaoAtribuidaException | ClienteNaoAtribuidoException | RacaoNaoAtribuidaException e3) {
				System.out.println(e3.getMessage());
			}

			try {
				Venda v3 = new Venda("10/10/2020", false, 0, null, racoes);
				System.out.println(v3);
			} catch (DataNaoAtribuidaException | ClienteNaoAtribuidoException | RacaoNaoAtribuidaException e4) {
				System.out.println(e4.getMessage());
			}
			try {
				Venda v4 = new Venda("10/10/2020", false, 60, cli, null);
				System.out.println(v4);
			} catch (DataNaoAtribuidaException | ClienteNaoAtribuidoException | RacaoNaoAtribuidaException e5) {
				System.out.println(e5.getMessage());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
