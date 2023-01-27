package model;

import org.json.JSONObject;

public class Endereco extends Entidade {

	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String logradouro;
	private int numero;
	private String pais;

	public Endereco(JSONObject json) {

		if (!(json.isNull("bairro"))) {
			this.bairro = json.getString("bairro");
		} else {
			this.bairro = "";
		}

		if (!(json.isNull("cep"))) {
			this.cep = json.getString("cep");
		} else {
			this.cep = "";
		}

		if (!(json.isNull("cidade"))) {
			this.cidade = json.getString("cidade");
		} else {
			this.cidade = "";
		}

		if (!(json.isNull("estado"))) {
			this.estado = json.getString("estado");
		} else {
			this.estado = "";
		}

		if (!(json.isNull("logradouro"))) {
			this.logradouro = json.getString("logradouro");
		} else {
			this.logradouro = "";
		}

		if (!(json.isNull("numero"))) {
			this.numero = json.getInt("numero");
		} else {
			this.numero = 0;
		}

		if (!(json.isNull("pais"))) {
			this.pais = json.getString("pais");
		} else {
			this.pais = "";
		}

	}

	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Endereco [bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado
				+ ", logradouro=" + logradouro + ", numero=" + numero + ", pais=" + pais + "]";
	}

}
