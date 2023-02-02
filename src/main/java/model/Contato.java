package model;

import org.json.JSONObject;

public class Contato extends Entidade {

	private Pessoa pessoa;
	private String tag;
	private String email;
	private String telefone;
	private String tipoContato;
	private boolean privado;
	private Usuario usuario;

	public Contato() {

	}

	public Contato(JSONObject json) {
		if (!(json.isNull("id"))) {
			super.setId(new Long(json.getInt("id")));
		} else {
			super.setId(0);
		}

		if (!(json.isNull("pessoa"))) {
			this.pessoa = new Pessoa(json);
		} else {
			this.pessoa = new Pessoa();
		}

		if (!(json.isNull("tag"))) {
			this.tag = json.getString("tag");
		} else {
			this.tag = "";
		}

		if (!(json.isNull("email"))) {
			this.email = json.getString("email");
		} else {
			this.email = "";
		}

		if (!(json.isNull("telefone"))) {
			this.telefone = json.getString("telefone");
		} else {
			this.telefone = "";
		}

		if (!(json.isNull("tipoContato"))) {
			this.tipoContato = json.getString("tipoContato");
		} else {
			this.tipoContato = "";
		}

		if (!(json.isNull("privado"))) {
			this.privado = json.getBoolean("privado");
		} else {
			this.privado = false;
		}

		if (!(json.isNull("usuario"))) {
			this.usuario = new Usuario(json);
		} else {
			this.usuario = new Usuario();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
	}

	public boolean isPrivado() {
		return privado;
	}

	public void setPrivado(boolean privado) {
		this.privado = privado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Contato [pessoa=" + pessoa + ", tag=" + tag + ", email=" + email + ", telefone=" + telefone
				+ ", tipoContato=" + tipoContato + ", privado=" + privado + ", usuario=" + usuario + "]";
	}

}
