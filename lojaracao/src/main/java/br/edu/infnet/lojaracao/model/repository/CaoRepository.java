package br.edu.infnet.lojaracao.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Cao;

public class CaoRepository {

	private static List<Cao> lista = new ArrayList<Cao>();
	
	public static void incluir(Cao cao) {
		try {
			lista.add(cao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Cao> obterLista() {
		return lista;
	}
}
