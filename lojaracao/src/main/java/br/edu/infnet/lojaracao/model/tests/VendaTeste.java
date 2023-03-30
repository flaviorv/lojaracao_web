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
		Cliente cli2 = new Cliente("Mariana Almeida", "154.555.686-98", "(55)99987-9876");
		List<Racao> listaRacao = new ArrayList<Racao>();
		
		Ave av2 = new Ave(1, "RacaoAve2", 234, 24.23f, "Canário", "Mamão", 1.2f);
		listaRacao.add(av2);

		Cao c2 = new Cao(1, "VaroCaoAmigo", 2519, 9.4f, true, false, "Grande Porte");
		listaRacao.add(c2);

		Gato g2 = new Gato(1, "VaroGatoArisco", 6549, 98.4f, "Peixe", true, false);
		listaRacao.add(g2);
		
		Venda v1 = new Venda();
		v1.setData("17/12/2022");
		v1.setCliente(cli2);
		v1.setEntrega(true);
		v1.setEndereco("Travessa Padre Cláudio, 233, Centro, Sao Paulo - SP");
		v1.setListaRacoes(listaRacao);
		
		System.out.println(v1.toString());
	}
}
