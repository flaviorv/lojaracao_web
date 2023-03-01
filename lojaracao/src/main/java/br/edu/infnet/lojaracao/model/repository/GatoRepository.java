package br.edu.infnet.lojaracao.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Gato;

public class GatoRepository {

	private static List<Gato> lista = new ArrayList<Gato>();
	
	public static void incluir(Gato gato) {
		try {
			lista.add(gato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Gato> obterLista() {
		return lista;
	}
}
