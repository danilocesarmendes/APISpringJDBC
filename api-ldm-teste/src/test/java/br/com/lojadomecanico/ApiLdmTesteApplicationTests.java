package br.com.lojadomecanico;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.lojadomecanico.dto.ItemDTO;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(classes = ApiLdmTesteApplicationTests.class),
		@ContextConfiguration(classes = ApiLdmTesteApplication.class) })
@SpringBootTest
public class ApiLdmTesteApplicationTests {

	@Test
	public void testApi() {
		String urlBase = "http://backstg.bseller.com.br/api/itens/estoque/massivo?tipoInterface=MECA&maxRegistros=10";
		URL obj;
		try {
			obj = new URL(urlBase);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("X-Auth-Token", "TOKEN_STG_LOJA_MECANICO");
			con.setDoOutput(true);

			assertEquals(con.getResponseCode(), HttpURLConnection.HTTP_OK);
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				System.out.println(response);
				Gson gson = new Gson();
				ItemDTO content = gson.fromJson(response.toString(), ItemDTO.class);
				
				System.out.println(content.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
