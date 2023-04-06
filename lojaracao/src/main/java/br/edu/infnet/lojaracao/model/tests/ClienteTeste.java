package br.edu.infnet.lojaracao.model.tests;

import br.edu.infnet.lojaracao.model.domain.Cliente;

public class ClienteTeste {
	public static void main(String[] args) {
		Cliente c1 = new Cliente("João Carlos da Silva", "11545645", "(54)3265-1552");
		System.out.println(c1.toString());
	}
}