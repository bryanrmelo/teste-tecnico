package view.backing;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import session.SessionContext;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String login;
	private String senha;

	public String doLogin() {
		try {
			if (validar()) {
				SessionContext.getInstance().setAttribute("usuario", login);
				return "/secure/home.xhtml?faces-redirect=true";
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().validationFailed();
			e.printStackTrace();
			return "";
		}

	}

	private boolean validar() {

		return true;
	}

	public String doLogout() {
		SessionContext.getInstance().encerrarSessao();
		return "/security/form_login.xhtml?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
