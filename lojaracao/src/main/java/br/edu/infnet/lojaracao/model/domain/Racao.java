package br.edu.infnet.lojaracao.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Racao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int codigo;
	private float preco;
	@ManyToOne
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;
	

	public Racao() {
		
	}

	public Racao(String nome, int codigo, float preco) {
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + nome);
		sb.append(";");
		sb.append(String.format("Preço: %.2f", calcularPrecoFinal(preco)));
		sb.append(";");
		sb.append("Código: " + codigo);
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}

	public float getPreco() {
		return preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public abstract float calcularPrecoFinal(float preco);

	public Integer getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
