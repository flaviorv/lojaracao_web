package br.edu.infnet.lojaracao.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.domain.Gato;
import br.edu.infnet.lojaracao.model.repository.GatoRepository;

@Service
public class GatoService {
	@Autowired
	private GatoRepository gatoRepository;

	public Gato incluir(Gato gato) {
		return gatoRepository.save(gato);
	}

	public void excluir(Integer id) {
		gatoRepository.deleteById(id);
	}

	public Collection<Gato> obterLista() {
		return (Collection<Gato>) gatoRepository.findAll();
	}

	public Collection<Gato> obterLista(Funcionario funcionario) {
		return gatoRepository.obterLista(Sort.by(Direction.ASC, "sabor"));
	}
}
