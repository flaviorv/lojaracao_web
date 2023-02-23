package br.edu.infnet.lojaracao.model.domain;

import java.util.List;

public class Venda {
	
	private String data;
	private boolean entrega = false;
	private String endereco;
	private Cliente cliente;
	private List<Racao> listaRacoes;
	
	@Override
	public String toString() {
		String s1 = String.format("Data: %s",  data );
		String s2 = String.format(";Clinte: %s", cliente.toString());
		String s3;
		if(entrega) {
			s3 = String.format(";Entregar: %s", endereco);
		}else {
			s3 = String.format(";Produto retirado pelo cliente");
		}
		String s4 = String.format(";Quantidade de Rações: %d", listaRacoes.size());
		
		return s1 + s2 + s3 + s4;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public boolean isEntrega() {
		return entrega;
	}

	public void setEntrega(boolean entrega) {
		this.entrega = entrega;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Racao> getListaRacoes() {
		return listaRacoes;
	}

	public void setListaRacoes(List<Racao> listaRacoes) {
		this.listaRacoes = listaRacoes;
	}
}