package br.edu.infnet.lojaracao.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.domain.Venda;
import br.edu.infnet.lojaracao.model.repository.VendaRepository;

@Service
public class VendaService {
	@Autowired
	private VendaRepository vendaRepository;

	public Venda incluir(Venda venda) {
		return vendaRepository.save(venda);
	}

	public void excluir(Integer id) {
		vendaRepository.deleteById(id);
	}

	public Collection<Venda> obterLista() {
		return (Collection<Venda>) vendaRepository.findAll();
	}

	public Collection<Venda> obterLista(Funcionario funcionario) {
		return vendaRepository.obterLista(Sort.by(Direction.ASC, "data"), funcionario.getId());
	}
	
}
