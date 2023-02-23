package br.edu.infnet.lojaracao.model.domain;

public class Cliente {
	private String nome;
	private String cpf;
	private String telefone;
	
	public Cliente (String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(cpf);
		sb.append(";");
		sb.append(telefone);
		
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}
}
