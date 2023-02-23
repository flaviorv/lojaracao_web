package br.edu.infnet.lojaracao.model.tests;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Ave;
import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.domain.Cliente;
import br.edu.infnet.lojaracao.model.domain.Gato;
import br.edu.infnet.lojaracao.model.domain.Racao;
import br.edu.infnet.lojaracao.model.domain.Venda;
import br.edu.infnet.lojaracao.model.exceptions.AtribuicaoInconsistenteException;
import br.edu.infnet.lojaracao.model.exceptions.NumeroBaixoException;
import br.edu.infnet.lojaracao.model.exceptions.PalavraInvalidaException;

public class VendaTeste {
	public static void main(String[] args) {
		Cliente cli2 = new Cliente("Mariana Almeida", "154.555.686-98", "(55)99987-9876");
		List<Racao> listaRacao = new ArrayList<Racao>();
		
		try {
			Ave av2 = new Ave("VaroCanário", 6549, 98.4f);
			av2.setAroma("Banana");
			av2.setPeso(2.6f);
			av2.setTipo("Canário");
			listaRacao.add(av2);
		} catch (PalavraInvalidaException | NumeroBaixoException e) {
			System.out.println(e.getMessage());	
		}
		

		try {
			Cao c2 = new Cao("VaroCaoAmigo", 2519, 9.4f);
			c2.setFilhotes(true);
			c2.setPorte("Grande Porte");
			c2.setSemCorante(false);
			listaRacao.add(c2);
		} catch (PalavraInvalidaException e) {
			System.out.println(e.getMessage());	
		}
		

		try {
			Gato g2 = new Gato("VaroGatoArisco", 6549, 98.4f);
			g2.setSabor("Peixe");
			g2.setFilhote(true);
			g2.setCastrado(false);
			listaRacao.add(g2);
		} catch (PalavraInvalidaException | AtribuicaoInconsistenteException e) {
			System.out.println(e.getMessage());	
		}
		
		
		Venda v1 = new Venda();
		v1.setData("17/12/2022");
		v1.setCliente(cli2);
		v1.setEntrega(true);
		v1.setEndereco("Travessa Padre Cláudio, 233, Centro, Sao Paulo - SP");
		v1.setListaRacoes(listaRacao);
		
		System.out.println(v1.toString());
	}
}
