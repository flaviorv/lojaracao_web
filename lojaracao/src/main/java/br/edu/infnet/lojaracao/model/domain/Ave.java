package br.edu.infnet.lojaracao.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.lojaracao.model.auxiliary.Constantes;

@Entity
public class Ave extends Racao {
	private String tipo;
	private String aroma;
	private float peso;

	public Ave() {
		
	}
	public Ave(String nome, int codigo, float preco, String tipo, String aroma, float peso) {
		super(nome, codigo, preco);
		this.tipo = tipo;
		this.aroma = aroma;
		this.peso = peso;
	}

	public String getTipo() {
		return tipo;
	}

	public String getAroma() {
		return aroma;
	}

	public float getPeso() {
		return peso;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setAroma(String aroma) {
		this.aroma = aroma;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	@Override
	public float calcularPrecoFinal(float preco) {
		if (tipo == Constantes.TIPO1 ) {
			preco += 1;
		} else if (tipo == Constantes.TIPO3) {
			preco += 54.4;
		}

		if (aroma == "Mamão") {
			preco += 23.34;
		} else if (aroma == Constantes.AROMA2) {
			preco += 43.34;
		}

		return preco * peso;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Mistura para " + tipo);
		sb.append(": " + super.getNome());
		sb.append(" - Aroma de " + aroma);
		sb.append(" - Peso: " + peso);
		sb.append(String.format(" - Preço: %.2f", calcularPrecoFinal(super.getPreco())));
		sb.append(" - Código: " + super.getCodigo());

		return sb.toString();
	}

}
