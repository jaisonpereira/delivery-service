package br.com.labswire.diarioProject.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.labswire.diarioProject.entity.Usuario;

/**
 * @author jpereira
 *
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	public List<Usuario> findAllBy(TextCriteria criteria, Pageable pages);

	public List<Usuario> findByNomeLikeIgnoreCase(String nome);

	public Usuario findByNome(String nome);

}
