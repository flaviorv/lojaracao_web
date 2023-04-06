package br.edu.infnet.lojaracao.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.lojaracao.model.auxiliary.Constantes;

@Entity
public class Cao extends Racao {
	private boolean semCorante = false;
	private boolean filhotes = false;
	private String porte;
	
	public Cao(){
		
	}

	public Cao(String nome, int codigo, float preco, boolean filhotes, boolean semCorante, String porte) {
		super(nome, codigo, preco);
		this.semCorante = semCorante;
		this.filhotes = filhotes;
		this.porte = porte;
	}

	public boolean isSemCorante() {
		return semCorante;
	}

	public boolean isFilhotes() {
		return filhotes;
	}

	public String getPorte() {
		return porte;
	}

	@Override
	public float calcularPrecoFinal(float preco) {
		if (semCorante) {
			preco += 10.32;
		}
		if (filhotes) {
			preco += 20;
		}
		if (porte == Constantes.PORTE1) {
			preco += 30;
		}
		if (porte == Constantes.PORTE2) {
			preco += 15;
		}
		return preco;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ração: " + super.getNome());
		if (filhotes) {
			sb.append("/Filhotes");
		} else {
			sb.append("/Adultos");
		}
		sb.append("/" + porte);
		sb.append(String.format(" - Preço: %.2f", calcularPrecoFinal(super.getPreco())));
		if (semCorante) {
			sb.append(" - Corante: sem corante");
		} else {
			sb.append(" - Corante: artificial");
		}
		sb.append(" - Código: " + super.getCodigo());
		

		return sb.toString();
	}

	public void setSemCorante(boolean semCorante) {
		this.semCorante = semCorante;
	}

	public void setFilhotes(boolean filhotes) {
		this.filhotes = filhotes;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

}
