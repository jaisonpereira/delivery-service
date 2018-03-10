package br.com.labswire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.labswire.diarioProject.entity.Pedido;
import br.com.labswire.diarioProject.entity.Usuario;
import br.com.labswire.diarioProject.repository.PedidoRepository;
import br.com.labswire.diarioProject.repository.UsuarioRepository;
import br.com.labswire.security.UserSpringSecurity;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repositoryPedido;

	@Autowired
	private UsuarioRepository repositoryUsuario;

	/**
	 * 
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 * @throws Exception
	 */
	public Page<Pedido> findPagePerUsuario(Integer page, Integer linesPerPage, String orderBy, String direction)
			throws Exception {
		UserSpringSecurity user = UsuarioService.authenticated();
		if (user == null) {
			throw new Exception("Usuario nao esta autenticado  Acesso negado");
		}

		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Usuario usuario = repositoryUsuario.findOne(user.getId());
		return repositoryPedido.findByUsuario(usuario, pageRequest);

	}

}
