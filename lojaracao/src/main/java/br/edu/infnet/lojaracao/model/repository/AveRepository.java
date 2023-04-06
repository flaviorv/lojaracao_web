package br.edu.infnet.lojaracao.model.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.lojaracao.model.domain.Ave;

@Repository
public interface AveRepository extends CrudRepository<Ave, Integer> {
	@Query("from Ave a")
	List<Ave> obterLista(Sort sort);
	
}
