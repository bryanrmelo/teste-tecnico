package model;

import org.json.JSONObject;

public class Pessoa extends Entidade {

	private String nome;
	private String cpf;
	private Endereco endereco;
	private Foto foto;

	public Pessoa() {

	}

	public Pessoa(JSONObject json) {

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

		if (!(json.isNull("cpf"))) {
			this.cpf = json.getString("cpf");
		} else {
			this.cpf = "";
		}

		if (!(json.isNull("endereco"))) {
			this.endereco = new Endereco((JSONObject) json.get("endereco"));
		} else {
			this.endereco = new Endereco();
		}

		if (!(json.isNull("foto"))) {
			this.foto = new Foto((JSONObject) json.get("foto"));
		} else {
			this.foto = new Foto();
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", foto=" + foto + "]";
	}

}
