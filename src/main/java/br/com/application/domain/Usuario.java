package br.com.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.application.enumeracao.TipoUsuario;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {
	
	@Column(unique = true)
	private String logon;
	
	@Column(nullable = false)
	private String username;
	
	@Column(length = 32, nullable = false)
	private String senha;
	
	@Transient private String senhaSemCriptografia;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	@Column(nullable = false)
	private Boolean ativo;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public String getLogon() {
		return logon;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setLogon(String logon) {
		this.logon = logon;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}
	
	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

	public Boolean getAtivo() {
		return ativo;
	}
	
	@Transient public String getAtivoFormatado(){
		String ativoFormatado = "Não";
		if(ativo){
			ativoFormatado = "Sim";
		}
		
		return ativoFormatado;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
