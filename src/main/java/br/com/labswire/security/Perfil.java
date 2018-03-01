package br.com.labswire.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author jpereira Classe que controla perfis de acesso classe Implementa
 *         GratedAuthority
 */
@Document
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = 6202657997795318909L;

	@Id
	private String id;

	private String nome;

	public Perfil(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nome;
	}

}
