package br.edu.infnet.lojaracao.model.tests;

import br.edu.infnet.lojaracao.model.domain.Racao;

public class RacaoTeste extends Racao{
	public RacaoTeste(Integer id, String nome, int codigo, float preco) {
		super(id, nome, codigo, preco);
	}
	@Override
	public float calcularPrecoFinal(float preco) {
		return preco * 2;
	}

	public static void main(String[] args) {
		RacaoTeste rt1 = new RacaoTeste(1, "VaroCrescimento", 2345, 234.43f);
		
		System.out.println(rt1.toString());
		
	}
}