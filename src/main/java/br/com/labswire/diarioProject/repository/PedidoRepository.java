package br.com.labswire.diarioProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.labswire.diarioProject.entity.Pedido;
import br.com.labswire.diarioProject.entity.Usuario;

/**
 * @author jpereira
 *
 */
public interface PedidoRepository extends MongoRepository<Pedido, String> {

	@Transactional(readOnly = true)
	Page<Pedido> findByUsuario(Usuario usuario, Pageable pageRequest);

}
