package br.edu.infnet.lojaracao.model.domain;

import br.edu.infnet.lojaracao.model.auxiliary.Constantes;

public class Ave extends Racao { 
	private String tipo; 
	private String aroma;
	private float peso;
	
	public Ave(String nome, int codigo, float preco, String tipo, String aroma, float peso){
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

	@Override
	public float calcularPrecoFinal(float preco){
		if(tipo == Constantes.TIPO2) {
			preco += 1;
		}else if(tipo == Constantes.TIPO3) {
			preco += 54.4;
		}
		
		if(aroma == Constantes.AROMA1 ) {
			preco += 23.34;
		}else if(aroma == Constantes.AROMA2) {
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
