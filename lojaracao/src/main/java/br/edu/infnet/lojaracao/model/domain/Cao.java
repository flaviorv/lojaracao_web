package br.edu.infnet.lojaracao.model.domain;
import br.edu.infnet.lojaracao.model.auxiliary.Constantes;
import br.edu.infnet.lojaracao.model.exceptions.PalavraInvalidaException;

public class Cao extends Racao {
	private boolean semCorante;
	private boolean filhotes;
	private String porte; 
	
	public boolean isSemCorante() {
		return semCorante;
	}
	public void setSemCorante(boolean semCorante) {
		this.semCorante = semCorante;
	}
	public boolean isFilhotes() {
		return filhotes;
	}
	public void setFilhotes(boolean filhotes) {
		this.filhotes = filhotes;
	}
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) throws PalavraInvalidaException{
		if(porte != Constantes.PORTE1 && porte != Constantes.PORTE2 && porte != Constantes.PORTE3) {
			throw new PalavraInvalidaException("Porte deve ser: " + Constantes.PORTE1 + ", " + Constantes.PORTE2 + " ou " + Constantes.PORTE3);
		}
		this.porte = porte;
	}
	
	public Cao(String nome, int codigo, float preco) {
		super(nome, codigo, preco);
	}
	@Override
	public float calcularPrecoFinal(float preco) {
		if(semCorante) {
			preco+=10.32;
		}
		if(filhotes) {
			preco+=20;
		}
		if(porte == Constantes.PORTE1) {
			preco+=30;
		}
		if(porte == Constantes.PORTE2) {
			preco+=15;
		}
		return preco;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ração: " + super.getNome());
		if(filhotes) {
			sb.append("/Filhotes");
		}else {
			sb.append("/Adultos");
		}
		sb.append("/" + porte);
		sb.append(String.format(" - Preço: %.2f", calcularPrecoFinal(super.getPreco())));
		if(semCorante) {
			sb.append(" - Corante: sem corante");
		}else {
			sb.append(" - Corante: artificial");
		}
		sb.append(" - Código: " + super.getCodigo());
		
		return sb.toString();
	}
	
}
