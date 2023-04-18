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

import br.edu.infnet.lojaracao.model.exceptions.ClienteNaoAtribuidoException;
import br.edu.infnet.lojaracao.model.exceptions.DataNaoAtribuidaException;
import br.edu.infnet.lojaracao.model.exceptions.RacaoNaoAtribuidaException;

@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String data;
	private boolean entrega = false;
	private int prazo;
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

	public Venda(String data, boolean entrega, int prazo, Cliente cliente, List<Racao> racoes)
			throws ClienteNaoAtribuidoException, RacaoNaoAtribuidaException, DataNaoAtribuidaException {
		this.data = data;
		this.entrega = entrega;
		this.prazo = prazo;
		this.cliente = cliente;
		this.racoes = racoes;

		if (cliente == null) {
			throw new ClienteNaoAtribuidoException("Cliente nao atribuido.");
		}
		if (racoes == null) {
			throw new RacaoNaoAtribuidaException("Racao nao Atribuida");
		}
		if (data == null) {
			throw new DataNaoAtribuidaException("Data nao Atribuida");
		}
	}

	@Override
	public String toString() {
		String s1 = String.format("Data: %s", data);
		String s2 = String.format(";Clinte: %s", cliente.toString());
		String s3;
		if (entrega) {
			s3 = String.format(";Entregar: %s", cliente.getEndereco());
		} else {
			s3 = String.format(";Produto retirado pelo cliente");
		}
		String s4;
		if (prazo > 0) {
			s4 = String.format(";Prazo: %s", prazo + " dias");
		} else {
			s4 = String.format(";Prazo: a vista");

		}
		String s5 = ";Racoes: ";
		for (Racao r : racoes) {
			s5 += r.getNome() + "/";
		}

		return s1 + s2 + s3 + s4 + s5;
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

	public List<Racao> getRacoes() throws RacaoNaoAtribuidaException {
		if (racoes == null) {
			throw new RacaoNaoAtribuidaException("Racao nao Atribuida");
		}
		return racoes;
	}

	public void setRacoes(List<Racao> listaRacoes) {
		this.racoes = listaRacoes;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
}