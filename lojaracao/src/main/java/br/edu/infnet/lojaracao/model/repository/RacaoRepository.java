package br.edu.infnet.lojaracao.model.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.lojaracao.model.domain.Racao;

@Repository
public interface RacaoRepository extends CrudRepository<Racao, Integer> {
	@Query("from Racao r where r.funcionario.id = :funcionarioId")
	List<Racao> obterLista(Sort sort, Integer funcionarioId);

}
