package br.com.lojadomecanico.service;

import java.util.List;

import br.com.lojadomecanico.model.Item;

public interface IEstoqueService {

	List<Item> serachItens(String interface_, Integer qtdRegistro);
	
	void insertEstoque(List<Item> itens);

}