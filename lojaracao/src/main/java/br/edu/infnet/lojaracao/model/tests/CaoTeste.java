package br.edu.infnet.lojaracao.model.tests;

import br.edu.infnet.lojaracao.model.domain.Cao;

public class CaoTeste {

	public static void main(String[] args) {
		Cao cachorroFeliz = new Cao("Cachorro Feliz", 111223, 5.60f, false, false, "Raças Pequenas");
		System.out.println(cachorroFeliz.toString());
	}

}
