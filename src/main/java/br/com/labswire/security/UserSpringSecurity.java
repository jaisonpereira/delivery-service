package br.com.labswire.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.labswire.enums.Perfil;

public class UserSpringSecurity implements UserDetails {

	private static final long serialVersionUID = -7415346058142492027L;
	private String id;
	private String nome;
	private String senha;

	private Collection<? extends GrantedAuthority> perfis;

	public String getId() {
		return id;
	}

	public UserSpringSecurity() {
	}

	public UserSpringSecurity(String id, String nome, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.perfis = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao()))
				.collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Collection<? extends GrantedAuthority> getPerfis() {
		return perfis;
	}

	public void setPerfis(Collection<? extends GrantedAuthority> perfis) {
		this.perfis = perfis;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return perfis;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	/**
	 * Aqui podemos definir o sistema de autenticacao se sera por login ou email
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nome;
	}

	/**
	 * Alterando para true
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

	public boolean hashHole(Perfil perfil) {

		return getPerfis().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

}
