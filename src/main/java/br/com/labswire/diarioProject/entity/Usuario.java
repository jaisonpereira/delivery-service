package br.com.labswire.diarioProject.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import br.com.labswire.security.Perfil;

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

	private List<Perfil> perfis = new ArrayList<>();

	private String senha;

	public Usuario() {

	}

	public Usuario(Usuario usuario) {
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.senha = usuario.getSenha();
		this.perfis = usuario.getPerfis();

	}

	public Usuario(String nome, List<Perfil> perfisUsuario, String senha) {
		this.nome = nome;
		this.senha = senha;
		this.perfis = perfisUsuario;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
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
