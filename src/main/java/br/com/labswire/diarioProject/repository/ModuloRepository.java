package br.com.labswire.diarioProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.labswire.diarioProject.entity.Modulo;

/**
 * @author jpereira
 *
 */
public interface ModuloRepository extends MongoRepository<Modulo, String> {

}
