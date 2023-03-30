package br.edu.infnet.lojaracao.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.lojaracao.model.domain.Cliente;

public class ClienteRepository {
	private static Integer id = 1;

	private static Map<Integer, Cliente> mapaCliente = new HashMap<Integer, Cliente>();

	public static Integer getId() {
		return id;
	}

	public static void setId() {
		ClienteRepository.id = id++;
	}

	public static void incluir(Cliente cliente) {
		try {
		cliente.setId(id++);
		mapaCliente.put(cliente.getId(), cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Collection<Cliente> obterLista() {
		return (Collection<Cliente>) mapaCliente.values();
	}

	public static boolean excluir(Integer id) {
		try {
			mapaCliente.remove(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
