package br.edu.infnet.lojaracao.model.domain;

import br.edu.infnet.lojaracao.model.auxiliary.Constantes;
import br.edu.infnet.lojaracao.model.exceptions.AtribuicaoInconsistenteException;
import br.edu.infnet.lojaracao.model.exceptions.PalavraInvalidaException;

public class Gato extends Racao {
	private String sabor;
	private boolean filhotes = false;
	private boolean castrado = false;
	
	public Gato(String nome, int codigo, float preco) {
		super(nome, codigo, preco);
	}
	

	public String getSabor() {
		
		return sabor;
	}

	public void setSabor(String sabor)  throws PalavraInvalidaException {
		if(sabor != Constantes.SABOR1 && sabor != Constantes.SABOR2 && sabor != Constantes.SABOR3) {
			throw new PalavraInvalidaException("Sabor deve ser: " + Constantes.SABOR1 + ", " + Constantes.SABOR2 + " ou " + Constantes.SABOR3);
		}
		this.sabor = sabor;
	}

	public boolean isFilhote() {
		return filhotes;
	}

	public void setFilhote(boolean filhotes) {
		this.filhotes = filhotes;
	}

	public boolean isCastrado() {
		return castrado;
	}

	public void setCastrado(boolean castrado) throws AtribuicaoInconsistenteException {
		if(filhotes && castrado) {
			throw new AtribuicaoInconsistenteException("Só há ração de castrados para adultos");
		}
		this.castrado = castrado;
	}
	
	@Override
	public float calcularPrecoFinal(float preco){
		if(sabor == Constantes.SABOR3) {
			preco+=15;
		}else if (sabor == Constantes.SABOR2) {
			preco+=5;
		}
		
		if(filhotes) {
			preco+=2.21;
		}
		
		if(castrado) {
			preco+=8;
		}
		
		
		return  preco;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ração: ");
		sb.append(super.getNome());
		if(filhotes) {
			sb.append("/Filhotes");
		}else {
			sb.append("/Adultos");
			if(castrado) {
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
