package br.com.labswire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.labswire.diarioProject.entity.Usuario;
import br.com.labswire.diarioProject.repository.UsuarioRepository;
import br.com.labswire.security.UserSpringSecurity;

@Service
public class UserDetailServiceWireLabs implements UserDetailsService {

	@Autowired
	private UsuarioRepository repositoryUsuario;

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {

		Usuario usuario = repositoryUsuario.findByNome(nome);

		if (usuario == null) {
			throw new UsernameNotFoundException(nome);
		}

		return new UserSpringSecurity(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getDescricaoPerfis());
	}

}
