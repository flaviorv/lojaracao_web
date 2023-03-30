package br.edu.infnet.lojaracao.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.lojaracao.model.domain.Ave;

public class AveRepository {
	private static Map<Integer, Ave> mapaAve = new HashMap<Integer, Ave>();
	public static boolean incluir(Ave ave) {
		try {
			Integer id = RacaoRepository.getId();
			ave.setId(id);
			RacaoRepository.setId(++id);
			mapaAve.put(ave.getId(), ave);
			System.out.println(RacaoRepository.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Collection<Ave> obterLista() {
		return (Collection<Ave>) mapaAve.values();
	}

	public static boolean excluir(Integer id) {
		try {
			mapaAve.remove(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
