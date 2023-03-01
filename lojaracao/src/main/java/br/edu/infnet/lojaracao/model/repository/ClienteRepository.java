package br.edu.infnet.lojaracao.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Cliente;

public class ClienteRepository {

	private static List<Cliente> lista = new ArrayList<Cliente>();
	
	public static void incluir(Cliente cliente) {
		try {
			lista.add(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Cliente> obterLista() {
		return lista;
	}
}
