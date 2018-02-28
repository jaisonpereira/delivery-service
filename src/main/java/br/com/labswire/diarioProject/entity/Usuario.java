package br.com.labswire.diarioProject.entity;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

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

	private String senha;

	public Usuario() {

	}

	public Usuario(Usuario usuario) {
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
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
