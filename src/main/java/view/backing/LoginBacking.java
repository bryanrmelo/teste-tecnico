package view.backing;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import service.LoginService;
import utils.SessionUtils;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBacking implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	@Inject
	private LoginService loginService;

	private String senha;
	private String msg;
	private String usuario;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String validar() {
		boolean valid = loginService.validate(usuario, senha);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("usuario", usuario);
			return "secure/home";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Usuário ou senha incorretos.", "Por favor, confira os dados."));
			return "login";
		}
	}

	// logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

}
