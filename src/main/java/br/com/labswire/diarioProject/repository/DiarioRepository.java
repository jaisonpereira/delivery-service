package br.com.labswire.diarioProject.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.labswire.diarioProject.entity.Aluno;
import br.com.labswire.diarioProject.entity.Diario;
import br.com.labswire.diarioProject.entity.Modulo;

/**
 * @author jpereira
 *
 */
public interface DiarioRepository extends MongoRepository<Diario, String> {

	List<Diario> findByAluno(Aluno aluno);

	List<Diario> findByModulo(Modulo modulo);

	List<Diario> findByDataBetween(Date dataDe, Date dataAte);

}
