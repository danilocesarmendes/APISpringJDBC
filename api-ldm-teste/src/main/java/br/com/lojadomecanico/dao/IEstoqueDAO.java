package br.com.lojadomecanico.dao;

import java.sql.Connection;
import java.util.List;

import br.com.lojadomecanico.model.Item;

public interface IEstoqueDAO {
	
	void addItens(List<Item> itens);
	
	Connection getConnection();
}