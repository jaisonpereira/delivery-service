package br.com.labswire.diarioProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.labswire.diarioProject.entity.Arquivo;

/**
 * @author jpereira
 *
 */
public interface ArquivoRepository extends MongoRepository<Arquivo, String> {

}
