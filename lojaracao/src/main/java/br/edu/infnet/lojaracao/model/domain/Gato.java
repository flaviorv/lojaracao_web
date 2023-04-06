package br.edu.infnet.lojaracao.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.lojaracao.model.auxiliary.Constantes;

@Entity
public class Gato extends Racao {

	private String sabor;
	private boolean filhotes = false;
	private boolean castrado = false;

	public Gato() {

	}

	public Gato(String nome, int codigo, float preco, String sabor, boolean filhotes, boolean castrado) {
		super(nome, codigo, preco);
		this.sabor = sabor;
		this.castrado = castrado;
		this.filhotes = filhotes;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public void setFilhotes(boolean filhotes) {
		this.filhotes = filhotes;
	}

	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}

	public String getSabor() {
		return sabor;
	}

	public boolean isFilhotes() {
		return filhotes;
	}

	public boolean isCastrado() {
		return castrado;
	}

	@Override
	public float calcularPrecoFinal(float preco) {
		if (sabor == Constantes.SABOR3) {
			preco += 15;
		} else if (sabor == Constantes.SABOR2) {
			preco += 5;
		}

		if (filhotes) {
			preco += 2.21;
		}

		if (castrado) {
			preco += 8;
		}

		return preco;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ração: ");
		sb.append(super.getNome());
		if (filhotes) {
			sb.append("/Filhotes");
		} else {
			sb.append("/Adultos");
			if (castrado) {
				sb.append("/Gato Castrado");
			}
		}
		sb.append(" - Sabor: ");
		sb.append(sabor);
		sb.append(" - Preço: ");
		sb.append(String.format("%.2f", calcularPrecoFinal(super.getPreco())));
		sb.append(" - Código: ");
		sb.append(super.getCodigo());

		return sb.toString();
	}

}
