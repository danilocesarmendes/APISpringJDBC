package br.com.lojadomecanico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.lojadomecanico.model.Item;
import br.com.lojadomecanico.model.ItemEstoque;

@Repository
public class EstoqueDAO implements IEstoqueDAO {

	@Override
	public void addItens(List<Item> itens) {
		Connection connection = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		for (Item item : itens) {

			String sqlItem = "INSERT INTO item (codigoItem, codigoDepartamento) values (?, ?)";
			String sqlItemEstoque = "INSERT INTO itemestoque (codigoEstabelecimento, quantidade, dataDisponivel, prazoDisponivel, quantidadeFisica, quantidadeAtenuada, item) "
					+ "values (?,?,?,?,?,?,?)";
			try {

				String queryItem = "SELECT * FROM ITEM WHERE codigoItem = " + item.getCodigoItem();
				rs = connection.createStatement().executeQuery(queryItem);
				if (!rs.next()) {
					System.out.println("item " + item.getCodigoItem());
					stmt = connection.prepareStatement(sqlItem);
					stmt.setInt(1, item.getCodigoItem().intValue());
					stmt.setInt(2, item.getCodigoDepartamento().intValue());
					stmt.execute();
				}

				for (ItemEstoque estoque : item.getEstoqueEstabelecimento()) {

					String queryEstoque = "SELECT * FROM ITEMESTOQUE WHERE codigoEstabelecimento = "
							+ estoque.getCodigoEstabelecimento() + " AND item = " + item.getCodigoItem();

					rs = connection.createStatement().executeQuery(queryEstoque);

					if (!rs.next()) {
						System.out.println("itemestoque " + estoque.getCodigoEstabelecimento());
						stmt = connection.prepareStatement(sqlItemEstoque);
						stmt.setInt(1, estoque.getCodigoEstabelecimento().intValue());
						stmt.setInt(2, estoque.getQuantidade().intValue());
						stmt.setDate(3, estoque.getDataDisponivel());
						stmt.setInt(4, estoque.getPrazoDisponivel().intValue());
						stmt.setInt(5, estoque.getQuantidadeFisica().intValue());
						stmt.setInt(6, estoque.getQuantidadeAtenuada().intValue());
						stmt.setLong(7, item.getCodigoItem());
						stmt.execute();
						stmt.close();
					}
				}

				rs.close();
			} catch (SQLException u) {
				throw new RuntimeException(u);
			}

		} // for
	}

	@Override
	public Connection getConnection() {
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return connection;
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_mecanico", "root", "root");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return connection;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

		return connection;
	}
}
