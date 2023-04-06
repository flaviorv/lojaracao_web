package br.edu.infnet.lojaracao.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario incluir(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public void excluir(Integer id) {
		funcionarioRepository.deleteById(id);
	}

	public Collection<Funcionario> obterLista() {
		return (Collection<Funcionario>) funcionarioRepository.findAll();
	}

	public Funcionario autenticar(Funcionario funcionario) {
		return funcionarioRepository.autenticacao(funcionario.getEmail(), funcionario.getSenha().toString());
	}

}
