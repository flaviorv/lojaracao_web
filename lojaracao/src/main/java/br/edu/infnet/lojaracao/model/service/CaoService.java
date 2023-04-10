package br.edu.infnet.lojaracao.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.repository.CaoRepository;

@Service
public class CaoService {
	@Autowired
	private CaoRepository caoRepository;

	public Cao incluir(Cao cao) {
		return caoRepository.save(cao);
	}

	public void excluir(Integer id) {
		caoRepository.deleteById(id);
	}

	public Collection<Cao> obterLista() {
		return (Collection<Cao>) caoRepository.findAll();
	}

	public Collection<Cao> obterLista(Funcionario funcionario) {
		return caoRepository.obterLista(Sort.by(Direction.ASC, "tipo"), funcionario.getId());
	}
}
