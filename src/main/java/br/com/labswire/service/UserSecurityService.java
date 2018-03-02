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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNome(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuaŕio ou senha inválidos");
		}

		return new UserSecurityDetails(usuario);

	}

}
