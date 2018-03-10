package br.com.labswire.enums;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author jpereira Classe responsavel por gerenciar perfils de
 *         acesso @PreAuthorize("hasAnyRole('ADMIN')") com essa anotation nos
 *         metodos limita o acesso
 */
public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"), CLIENTE(2, "ROLE_CLIENTE");

	private Integer cod;
	private String descricao;

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private Perfil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public static Perfil toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("codigo Perfil invalido: " + cod);

	}

}
