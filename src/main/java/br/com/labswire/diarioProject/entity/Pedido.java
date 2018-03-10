package br.com.labswire.diarioProject.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Pedido extends EntidadeGenerica {

	private String descricao;

	@DBRef
	private Usuario usuario;

	public Pedido(String descricao) {
		this.descricao = descricao;
	}

	public Pedido() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
