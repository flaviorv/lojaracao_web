package br.edu.infnet.lojaracao.model.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.edu.infnet.lojaracao.model.domain.Cliente;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente incluir(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Integer cpf) {
		clienteRepository.deleteById(cpf);
	}
	
	public Collection<Cliente> obterLista(){
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Collection<Cliente> obterLista(Funcionario funcionario){
		return clienteRepository.obterLista( Sort.by(Direction.ASC, "cpf"));
	}

}
