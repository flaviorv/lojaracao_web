package br.edu.infnet.lojaracao.model.tests;

import br.edu.infnet.lojaracao.model.domain.Gato;

public class GatoTeste {
	
	public static void main(String[] args) {
		
		Gato miau = new Gato(1, "Miau", 23456, 45.78f, "Peixe", false, true);
		System.out.println(miau.toString());
	}
}