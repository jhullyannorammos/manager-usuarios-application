package br.com.application.domain;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "grupo")
public class Grupo extends GenericDomain {

	@ManyToMany
	@JoinTable(name = "grupo_permissao", joinColumns = @JoinColumn(name="grupo_id"),
			inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao> permissoes;
	
	@Column(nullable=false, length=80)
	private String descricao;
	
	@Column(nullable=false, length=40)
	private String nome;
	
	public Grupo() {
		// TODO Auto-generated constructor stub
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
