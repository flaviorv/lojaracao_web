package br.edu.infnet.lojaracao.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.lojaracao.model.domain.Cao;

public class CaoRepository {

private static Map<Integer, Cao> mapaCao = new HashMap<Integer, Cao>();
	
	public static boolean incluir(Cao cao) {
		try {
			Integer id = RacaoRepository.getId();
			cao.setId(id);
			RacaoRepository.setId(++id);
			mapaCao.put(cao.getId(), cao);
			System.out.println(RacaoRepository.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Collection<Cao> obterLista() {
		return (Collection<Cao>) mapaCao.values();
	}

	public static boolean excluir(Integer id) {
		try {
			mapaCao.remove(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
