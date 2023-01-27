package model;

import org.json.simple.JSONObject;

public class JSONParseObject extends JSONObject {

	private static final long serialVersionUID = 1L;
	private Pessoa object;
	private String message;

	public Pessoa getObject() {
		return object;
	}

	public void setObject(Pessoa object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JSONParseObject [object=" + object + ", message=" + message + "]";
	}

}
