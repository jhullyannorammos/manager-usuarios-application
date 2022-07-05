package br.com.application.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;
import br.com.application.domain.Usuario;
import br.com.application.enumeracao.TipoUsuario;
import br.com.application.persistence.UsuarioPersistence;

public class UsuarioDAOTest {
	@Test
	// @Ignore
	public void salvar(){
		
		System.out.println("Pessoa Encontrada");
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setSenhaSemCriptografia("q1w2e3r4");
		
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
		usuario.setSenha(hash.toHex());
		
		usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
		
		UsuarioPersistence usuarioDAO = new UsuarioPersistence();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso.");
	}
	
	@Test
	@Ignore
	public void autenticar(){
		String cpf = "999.999.999-99";
		String senha = "12345678";
		
		UsuarioPersistence usuarioDAO = new UsuarioPersistence();
		Usuario usuario = usuarioDAO.autenticar(cpf, senha);
		
		System.out.println("Usuário autentica: " + usuario);
	}
}	
