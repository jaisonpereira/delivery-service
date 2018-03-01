package br.com.labswire.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.labswire.diarioProject.entity.Usuario;

/**
 * @author jpereira
 *
 */
public class UserSecurityDetails extends Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4040327201405964344L;

	public UserSecurityDetails(Usuario usuario) {
		super(usuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getPerfis();
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	/**
	 * Poderia retornar o email caso a autenticacao fosse por email
	 */
	@Override
	public String getUsername() {
		return getNome();
	}

	/**
	 * METODOS ABAIXO AINDA NAO FORAM IMPLEMENTADOS
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
