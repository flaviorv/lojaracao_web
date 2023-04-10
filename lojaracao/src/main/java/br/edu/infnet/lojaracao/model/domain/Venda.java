package br.edu.infnet.lojaracao.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String data;
	private boolean entrega = false;
	private String endereco;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Racao> racoes;
	@ManyToOne
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;
	
	
	public Venda() {
		
	}
	
	public Venda(String data, boolean entrega, String endereco, Cliente cliente, List<Racao> racoes) {
		this.data = data;
		this.entrega = entrega;
		this.endereco = endereco;
		this.cliente = cliente;
		this.racoes = racoes;
	}

	@Override
	public String toString() {
		String s1 = String.format("Data: %s", data);
		String s2 = String.format(";Clinte: %s", cliente.toString());
		String s3;
		if (entrega) {
			s3 = String.format(";Entregar: %s", endereco);
		} else {
			s3 = String.format(";Produto retirado pelo cliente");
		}
		String s4 = String.format(";Quantidade de Rações: %d");

		return s1 + "s2" + s3 + s4;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Racao> getListaRacoes() {
		return racoes;
	}

	public void setListaRacoes(List<Racao> listaRacoes) {
		this.racoes = listaRacoes;
	}
}