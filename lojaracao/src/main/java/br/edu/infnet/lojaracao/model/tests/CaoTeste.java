package br.edu.infnet.lojaracao.model.tests;

import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.exceptions.PalavraInvalidaException;

public class CaoTeste {
	
	public static void main(String[] args) {
		try {
			Cao cachorroFeliz = new Cao("Cachorro Feliz", 111223, 5.60f);
			cachorroFeliz.setFilhotes(false);
			cachorroFeliz.setPorte("Raças Pequenas");
			cachorroFeliz.setSemCorante(false);
			System.out.println(cachorroFeliz.toString());
		} catch (PalavraInvalidaException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
