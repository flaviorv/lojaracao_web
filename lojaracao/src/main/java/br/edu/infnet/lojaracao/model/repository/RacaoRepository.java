package br.edu.infnet.lojaracao.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.lojaracao.model.domain.Racao;

public class RacaoRepository {
	private static Integer id = 1;
	private static Map<Integer, Racao> mapaRacao = new HashMap<Integer, Racao>();
	
	public static boolean incluir(Racao racao) {
		try {
			mapaRacao.put(racao.getId(), racao);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Collection<Racao> obterLista() {
		return (Collection<Racao>) mapaRacao.values();
	}

	public static boolean excluir(Integer id) {
		try {
			mapaRacao.remove(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		RacaoRepository.id = id;
	}
}
