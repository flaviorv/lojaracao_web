package br.edu.infnet.lojaracao.model.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.lojaracao.model.domain.Cao;

@Repository
public interface CaoRepository extends CrudRepository<Cao, Integer> {
	@Query("from Cao c")
	List<Cao> obterLista(Sort sort);

}
