package br.edu.infnet.lojaracao.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Ave;

public class AveRepository {
	private static List<Ave> lista = new ArrayList<Ave>();
	
	public static void incluir(Ave ave) {
		try {
			lista.add(ave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Ave> obterLista() {
		return lista;
	}
}
