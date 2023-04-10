package br.edu.infnet.lojaracao.model.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.lojaracao.model.domain.Gato;

@Repository
public interface GatoRepository extends CrudRepository<Gato, Integer>{
	@Query("from Gato g where g.funcionario.id = :funcionarioId")
	List<Gato> obterLista(Sort sort, Integer funcionarioId);

}
