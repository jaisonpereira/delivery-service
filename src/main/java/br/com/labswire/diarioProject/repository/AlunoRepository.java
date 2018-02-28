package br.com.labswire.diarioProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.labswire.diarioProject.entity.Aluno;

/**
 * @author jpereira
 *
 */
public interface AlunoRepository extends MongoRepository<Aluno, String> {

}
