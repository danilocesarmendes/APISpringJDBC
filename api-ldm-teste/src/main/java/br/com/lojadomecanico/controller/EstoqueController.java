package br.com.lojadomecanico.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lojadomecanico.model.Item;
import br.com.lojadomecanico.service.IEstoqueService;

@Controller
@RequestMapping("/api")
public class EstoqueController {

	/**
	 * Objeto Logger
	 */
	private final Logger LOGGER = Logger.getLogger(EstoqueController.class);
	
	@Autowired
	private IEstoqueService estoqueService;

	@PostMapping("/estoque/{interface}/{qtdRegistro}")
	public ResponseEntity<Void> addArticle(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@PathVariable("interface") String interface_,
			@PathVariable("qtdRegistro") Integer qtdRegistro ){

		LOGGER.info("/estoque/{interface}/{qtdRegistro}");
		

		List<Item> itens = estoqueService.serachItens(interface_, qtdRegistro);
		
		estoqueService.insertEstoque(itens);
		
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/status",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> statusApi(){
		LOGGER.info("method GET /status");
		
		String msg = "Ok!";
		try {
			return new ResponseEntity<>(msg, HttpStatus.OK);
		} catch (Exception e) {
			msg = "Exception!";
			e.printStackTrace();
			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
