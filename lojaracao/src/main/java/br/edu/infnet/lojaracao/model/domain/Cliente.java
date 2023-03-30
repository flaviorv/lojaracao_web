package br.edu.infnet.lojaracao.model.domain;

public class Cliente {
	private Integer id;
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
		sb.append(";");
		sb.append(id);
		
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
