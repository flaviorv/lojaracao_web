package br.edu.infnet.lojaracao.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Racao;

public class RacaoRepository {
	
	private static List<Racao> lista = new ArrayList<Racao>();
	
	public static void incluir(Racao racao) {
		try {
			lista.add(racao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Racao> obterLista(){
		return lista;
	}
}
