package br.com.labswire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.labswire.diarioProject.entity.Usuario;
import br.com.labswire.diarioProject.repository.UsuarioRepository;
import br.com.labswire.enums.Perfil;
import br.com.labswire.security.UserSpringSecurity;

/**
 * @author jpereira
 *
 */
@Service
public class UsuarioService {

	public static UserSpringSecurity authenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	public Page<Usuario> listaPaginada(int count, int page) {
		Pageable pages = new PageRequest(page, count);
		return usuarioRepository.findAll(pages);
	}

	public List<Usuario> buscaPorNome(String nome) {
		return usuarioRepository.findByNomeLikeIgnoreCase(nome);
	}

	public Usuario salvarUsuario(Usuario usuarioAdd) {
		// encriptando a senha
		usuarioAdd.setSenha(encoder.encode(usuarioAdd.getSenha()));

		return usuarioRepository.save(usuarioAdd);
	}

	public void deleteUsuario(String id) {
		usuarioRepository.delete(id);
	}

	/**
	 * Implementando acesso sopmente a ele mesmo
	 * 
	 * @param id
	 * @return
	 */
	public Usuario getById(String id) {
		UserSpringSecurity user = authenticated();
		if (user == null || !user.hashHole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new RuntimeException("Acesso negado");
		}

		return usuarioRepository.findOne(id);
	}
}
