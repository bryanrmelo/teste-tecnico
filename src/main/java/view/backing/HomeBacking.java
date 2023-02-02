package view.backing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.ws.rs.core.HttpHeaders;

import org.json.JSONObject;

import model.Contato;

@Named("homeBean")
@ManagedBean
public class HomeBacking {

	private String urlApi = "https://demometaway.vps-kinghost.net:8485/api/";
	
	private List<Contato> contatos = new ArrayList<Contato>();
	
	@PostConstruct
	public void ini() {
		
		preencherLista();
	}
	
	private void preencherLista() {
		for (int i = 1; i < 4; i++) {
			try {
				URL url = new URL(urlApi + "contato/listar/" + i);
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

				System.out.println(response.toString());
				JSONObject json = new JSONObject(response.toString());
				System.out.println(json);
				Contato contato = new Contato(json);
				this.contatos.add(contato);

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

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
}
