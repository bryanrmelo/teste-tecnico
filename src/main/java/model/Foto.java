package model;

import org.json.JSONObject;

public class Foto extends Entidade {

	private String name;
	private String type;

	public Foto() {

	}

	public Foto(JSONObject json) {

		if (!(json.isNull("name"))) {
			this.name = json.getString("name");
		} else {
			this.name = "";
		}
		if (!(json.isNull("type"))) {
			this.type = json.getString("type");
		} else {
			this.type = "";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Foto [name=" + name + ", type=" + type + "]";
	}
}
