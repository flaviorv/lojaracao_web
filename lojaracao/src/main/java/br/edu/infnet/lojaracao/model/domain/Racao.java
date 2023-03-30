package br.edu.infnet.lojaracao.model.domain;

public abstract class Racao {
	private Integer id;
	private String nome;
	private int codigo;
	private float preco;

	public Racao(Integer id, String nome, int codigo, float preco) {
		this.id = id;
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

	public void setId(Integer id) {
		this.id = id;
	}

}
