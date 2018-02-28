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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
