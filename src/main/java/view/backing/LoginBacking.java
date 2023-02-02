package view.backing;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.LoginService;

@Named("loginBean")
@ViewScoped
public class LoginBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LoginService loginService;
	
	private String usuario;
	private String senha;
	
	public String logar() {
		return "../secure/home.xhtml?faces-redirect=true";
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
