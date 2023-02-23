package br.edu.infnet.lojaracao.model.domain;

public class Usuario {
	 private String nome;
	 private String email;
	 private String senha;
	 private String[] caracteristicas;
	 private String tipo;
	 private String setor;
	 private int idade;
	 private float salario;
	 
	 public Usuario(String nome, 
			 		String email, String senha, 
			 		String[] caracteristicas, String tipo, 
			 		String setor, 
			 		int idade, 
			 		String salario) 
	 { 
		 this.nome = nome;
		 this.email = email;
		 this.senha = senha;
		 this.caracteristicas = caracteristicas;
		 this.tipo = tipo;
		 this.setor = setor;
		 this.idade = idade;
		 this.salario = Float.parseFloat(salario);
	 }
	 
	 @Override
	 public String toString() {
		 return String.format(
				 "O usuário %s tem as credenciais %s e %s, %d anos e ganha R$%.2f. É um usuário do tipo %s, atua no setor %s e tem %d características", nome, email, senha, idade, salario, tipo, setor, caracteristicas.length);
	 }
	 
}
