package br.edu.infnet.lojaracao.model.tests;

import br.edu.infnet.lojaracao.model.domain.Gato;
import br.edu.infnet.lojaracao.model.exceptions.AtribuicaoInconsistenteException;
import br.edu.infnet.lojaracao.model.exceptions.PalavraInvalidaException;

public class GatoTeste {
	
	public static void main(String[] args) {
		
		try {
			Gato miau = new Gato("Miau", 23456, 45.78f);
			miau.setSabor("Peixe");
			miau.setFilhote(false);
			miau.setCastrado(true);
			System.out.println(miau.toString());
		} catch (AtribuicaoInconsistenteException | PalavraInvalidaException e) {
			System.out.println(e.getMessage());
		}
	}
}