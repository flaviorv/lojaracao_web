package br.edu.infnet.lojaracao.model.domain;

public class Funcionario {
	 private String nome;
	 private String email;
	 private String senha;
	 
	 public Funcionario(String nome, String email, String senha) 
	 { 
		 setNome(nome);
		 setEmail(email);
		 setSenha(senha);
	 }

	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getSenha() {
		return senha;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	 
}
