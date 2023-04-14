package br.edu.infnet.lojaracao.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.domain.Racao;
import br.edu.infnet.lojaracao.model.repository.RacaoRepository;

@Service
public class RacaoService {
	@Autowired
	private RacaoRepository racaoRepository;

	public Racao incluir(Racao racao) {
		return racaoRepository.save(racao);
	}

	public void excluir(Integer id) {
		racaoRepository.deleteById(id);
	}

	public Collection<Racao> obterLista() {
		return (Collection<Racao>) racaoRepository.findAll();
	}

	public Collection<Racao> obterLista(Funcionario funcionario) {
		return racaoRepository.obterLista(Sort.by(Direction.ASC, "preco"), funcionario.getId());
	}
	
	public Racao obterRacao(Integer Id) {
		return racaoRepository.obterRacao(Id);
	}
}
