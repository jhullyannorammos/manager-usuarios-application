package br.com.application.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.model.menu.MenuModel;

import br.com.application.domain.Usuario;
import br.com.application.enumeracao.TipoUsuario;
import br.com.application.persistence.UsuarioPersistence;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	public void autenticar() {
		try {
			UsuarioPersistence usuarioDAO = new UsuarioPersistence();
			usuarioLogado = usuarioDAO.autenticar(usuario.getLogon(), usuario.getSenha());
			
			if(usuarioLogado == null){
				Messages.addGlobalError("CPF e/ou senha incorretos");
				return;
			}
			
			Faces.redirect("./pages/principal.xhtml");
		} catch (Exception erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
	}
	
//	public boolean temPermissoes(List<String> permissoes){	
//		for(String permissao : permissoes){
//			if(usuarioLogado.getTipo() == permissao.charAt(0)){
//				return true;
//			}
//		}
//		
//		return false;
//	}
	
}
