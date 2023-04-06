package br.edu.infnet.lojaracao.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.edu.infnet.lojaracao.model.domain.Ave;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.repository.AveRepository;

@Service
public class AveService {
	@Autowired
	private AveRepository aveRepository;

	public Ave incluir(Ave ave) {
		return aveRepository.save(ave);
	}

	public void excluir(Integer id) {
		aveRepository.deleteById(id);
	}

	public Collection<Ave> obterLista() {
		return (Collection<Ave>) aveRepository.findAll();
	}

	public Collection<Ave> obterLista(Funcionario funcionario) {
		return aveRepository.obterLista(Sort.by(Direction.ASC, "tipo"));
	}
}
