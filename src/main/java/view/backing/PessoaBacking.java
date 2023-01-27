package view.backing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.core.HttpHeaders;

import org.json.JSONObject;

import model.Pessoa;

@Named("pessoaBean")
@ViewScoped
public class PessoaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private String urlApi = "https://demometaway.vps-kinghost.net:8485/api/";

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	@PostConstruct
	public void ini() {
		preencherLista();
	}

	// Workaround para criar uma lista de pessoas
	private void preencherLista() {
		for (int i = 1; i < 4; i++) {
			try {
				URL url = new URL(urlApi + "pessoa/buscar/" + i);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty(HttpHeaders.AUTHORIZATION, "Bearer "
						+ "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY3NDc2NTI3MywiZXhwIjoxNjc0ODUxNjczfQ.7Helf4eOMwmzgqKNdWFEWBXwO1x7nh1Hks2957t83f7-eMM-qwctbqOeCWSgX4HpGxtUPU8CstaSf10RszRVLQ");
				conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
				conn.setRequestMethod("GET");
				conn.connect();

				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String output;

				StringBuffer response = new StringBuffer();
				while ((output = in.readLine()) != null) {
					response.append(output);
				}

				JSONObject jsonObject = new JSONObject(response.toString());

				JSONObject messageObject = new JSONObject();
				messageObject.put("message", jsonObject.get("message"));
				JSONObject pessoaObject = new JSONObject();
				pessoaObject.put("object", jsonObject.get("object"));
				JSONObject json = (JSONObject) pessoaObject.get("object");

				Pessoa pessoa = new Pessoa(json);
				this.pessoas.add(pessoa);

				in.close();

			} catch (MalformedURLException e) {
				System.out.println("Erro na URL!");
				e.printStackTrace();
				break;
			} catch (IOException ex) {
				System.out.println("Erro ao conectar a URL!");
				ex.printStackTrace();
				break;
			}
		}
	}

	public List<Pessoa> getPessoas() {
		System.out.println(pessoas);
		return pessoas;

	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
