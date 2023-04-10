package br.edu.infnet.lojaracao.model.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.edu.infnet.lojaracao.model.domain.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer>{
	@Query("from Venda v where v.funcionario.id = :funcionarioId")
	List<Venda> obterLista(Sort sort, Integer funcionarioId);
}
