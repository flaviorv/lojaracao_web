package br.edu.infnet.lojaracao.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.lojaracao.model.domain.Funcionario;

public class FuncionarioRepository {
	private static List<Funcionario> lista = new ArrayList<Funcionario>();
	private static boolean funcionarioLogado = false;
	private static String funcionarioStatus = "";

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
	
	public static void incluir(Funcionario funcionario) {
		try {
			lista.add(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean validarAcesso(Funcionario funcionario) {
		for (Funcionario f : lista) {
			System.out.printf("email %s email %s boolean %b", funcionario.getEmail(), f.getEmail(), 
					(funcionario.getEmail().equals(f.getEmail())));
			
			if(funcionario.getEmail().equals(f.getEmail()) && funcionario.getSenha().equals(f.getSenha())){
				funcionario.setNome(f.getNome());
				setFuncionarioLogado(true); ;
			}
		}
		return isFuncionarioLogado();
	}
	
	public static void encerrarSessao() {
		setFuncionarioLogado(false);
		setFuncionarioStatus("");
	}
	
}
