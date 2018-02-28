package br.com.labswire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.labswire.diarioProject.entity.Usuario;
import br.com.labswire.diarioProject.repository.UsuarioRepository;
import br.com.labswire.security.UserSecurityDetails;

/**
 * @author jpereira
 *
 */
@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// podemos autenticar por email - cpf e etc
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNome(userName);
		if (usuario == null) {
			throw new UsernameNotFoundException("User ou Senha inválida");
		}

		return new UserSecurityDetails(usuario);

	}

}
