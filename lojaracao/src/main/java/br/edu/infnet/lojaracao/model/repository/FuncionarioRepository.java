package br.edu.infnet.lojaracao.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.infnet.lojaracao.model.domain.Funcionario;

public class FuncionarioRepository {
	private static Map<String, Funcionario> mapaFuncionario = new HashMap<String, Funcionario>();
	private static boolean funcionarioLogado = false;
	private static String funcionarioStatus = "";

	public static Collection<Funcionario> obterLista() {
		return mapaFuncionario.values();
	}

	public static boolean incluir(Funcionario funcionario) {
		try {
			mapaFuncionario.put(funcionario.getEmail(), funcionario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean excluir(String email) {
		try {
			mapaFuncionario.remove(email);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isFuncionarioLogado() {
		return funcionarioLogado;
	}

	public static void setFuncionarioLogado(boolean status) {
		funcionarioLogado = status;
	}

	public static String getFuncionarioStatus() {
		return funcionarioStatus;
	}

	public static void setFuncionarioStatus(String funcionarioStatus) {
		FuncionarioRepository.funcionarioStatus = funcionarioStatus;
	}

	public static boolean validarAcesso(Funcionario funcionario) {
		try {
			if (mapaFuncionario.get(funcionario.getEmail()).getSenha().equals(funcionario.getSenha())) {
				setFuncionarioLogado(true);
				funcionario.setNome(mapaFuncionario.get(funcionario.getEmail()).getNome());
				setFuncionarioStatus(funcionario.getNome());
			}

			return isFuncionarioLogado();
		} catch (Exception e) {

			return isFuncionarioLogado();
		}
	}

	public static void encerrarSessao() {
		setFuncionarioLogado(false);
		setFuncionarioStatus("");
	}

}
