package br.com.lojadomecanico.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.lojadomecanico.dao.IEstoqueDAO;
import br.com.lojadomecanico.dto.ItemDTO;
import br.com.lojadomecanico.model.Item;

@Service
public class EstoqueService implements IEstoqueService {

	@Autowired
	private IEstoqueDAO estoqueDAO;

	@Override
	public List<Item> serachItens(String interface_, Integer qtdRegistro) {
		List<Item> itens = null;
		
		String urlBase = "http://backstg.bseller.com.br/api/itens/estoque/massivo?tipoInterface=" + interface_
				+ "&maxRegistros=" + qtdRegistro;

		System.out.println("urlBase: " + urlBase);
		
		
		URL obj;
		try {
			obj = new URL(urlBase);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("X-Auth-Token", "TOKEN_STG_LOJA_MECANICO");
			con.setDoOutput(true);

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
				itens = content.getContent();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itens;
	}

	@Override
	public void insertEstoque(List<Item> itens) {
		estoqueDAO.addItens(itens);
	}
}