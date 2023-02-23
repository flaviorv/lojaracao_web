package br.edu.infnet.lojaracao.model.domain;
import br.edu.infnet.lojaracao.model.auxiliary.Constantes;
import br.edu.infnet.lojaracao.model.exceptions.NumeroBaixoException;
import br.edu.infnet.lojaracao.model.exceptions.PalavraInvalidaException;

public class Ave extends Racao { 
	private String tipo; 
	private String aroma;
	private float peso;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) throws PalavraInvalidaException {
		if(tipo != Constantes.TIPO1 && tipo != Constantes.TIPO2 && tipo != Constantes.TIPO3) {
			throw new PalavraInvalidaException("Tipo de Pássaro deve ser: " + Constantes.TIPO1 + ", " + Constantes.TIPO2 + " ou " + Constantes.TIPO3);
		}
		this.tipo = tipo;
	}

	public String getAroma() {
		return aroma;
	}

	public void setAroma(String aroma) throws PalavraInvalidaException {
		if(aroma != Constantes.AROMA1 && aroma != Constantes.AROMA2 && aroma != Constantes.AROMA3) {
			throw new PalavraInvalidaException("Aroma deve ser: " + Constantes.AROMA1 + ", " + Constantes.AROMA2 + " ou " + Constantes.AROMA3);
		}
		this.aroma = aroma;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) throws NumeroBaixoException {
		if(peso <= 0) {
			throw new NumeroBaixoException("Peso deve ser maior que zero");
		}
		
		this.peso = peso;
	}
	
	
	public Ave(String nome, int codigo, float preco) {
		super(nome, codigo, preco);
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
