package br.edu.infnet.lojaracao.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.lojaracao.model.domain.Gato;

public class GatoRepository {

	private static Map<Integer, Gato> mapaGato = new HashMap<Integer, Gato>();
	
	public static boolean incluir(Gato gato) {
		try {
			Integer id = RacaoRepository.getId();
			gato.setId(id);
			RacaoRepository.setId(++id);
			mapaGato.put(gato.getId(), gato);
			System.out.println(RacaoRepository.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Collection<Gato> obterLista() {
		return (Collection<Gato>) mapaGato.values();
	}

	public static boolean excluir(Integer id) {
		try {
			mapaGato.remove(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
