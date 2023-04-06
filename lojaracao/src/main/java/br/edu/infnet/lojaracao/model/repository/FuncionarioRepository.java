package br.edu.infnet.lojaracao.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.lojaracao.model.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
	@Query("from Funcionario f where f.email = :email and f.senha = :senha")
	Funcionario autenticacao(String email, String senha);
}
