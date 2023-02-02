package model;

import org.json.JSONObject;

public class Usuario extends Entidade {

	private String nome;
	private String dataNascimento;
	private String cpf;
	private String email;
	private String telefone;
	private String username;
	private String password;

	public Usuario() {
	}

	public Usuario(JSONObject json) {
		if (!(json.isNull("id"))) {
			super.setId(new Long(json.getInt("id")));
		} else {
			super.setId(0);
		}

		if (!(json.isNull("nome"))) {
			this.nome = json.getString("nome");
		} else {
			this.nome = "";
		}

		if (!(json.isNull("dataNascimento"))) {
			this.dataNascimento = json.getString("dataNascimento");
		} else {
			this.dataNascimento = "";
		}

		if (!(json.isNull("cpf"))) {
			this.cpf = json.getString("cpf");
		} else {
			this.cpf = "";
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

		if (!(json.isNull("username"))) {
			this.username = json.getString("username");
		} else {
			this.username = "";
		}

		if (!(json.isNull("password"))) {
			this.password = json.getString("password");
		} else {
			this.password = "";
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", email=" + email
				+ ", telefone=" + telefone + ", username=" + username + ", password=" + password + "]";
	}

}
