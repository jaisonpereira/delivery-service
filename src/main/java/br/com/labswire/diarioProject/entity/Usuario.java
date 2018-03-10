package br.com.labswire.diarioProject.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.labswire.enums.Perfil;

/**
 * @author jpereira Classe utilizando full text search
 */
@Document
public class Usuario extends EntidadeGenerica {

	@TextIndexed
	private String nome;

	@TextIndexed
	private String sobrenome;

	@TextScore
	private Float score;

	private Set<Integer> perfis = new HashSet<>();

	@JsonIgnore
	private String senha;

	public Usuario() {
		addPerfil(Perfil.CLIENTE);
	}

	public Usuario(Usuario usuario) {
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.senha = usuario.getSenha();
	}

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
	}

	@JsonIgnore
	public Set<br.com.labswire.enums.Perfil> getDescricaoPerfis() {
		return perfis.stream().map(x -> br.com.labswire.enums.Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public Set<Integer> getPerfis() {
		return perfis;
	}

	public void addPerfil(br.com.labswire.enums.Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
