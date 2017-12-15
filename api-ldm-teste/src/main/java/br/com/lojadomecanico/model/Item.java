package br.com.lojadomecanico.model;

import java.util.List;

public class Item {

	private Long codigoItem;
	
	private Integer codigoDepartamento;
	
	private List<ItemEstoque> estoqueEstabelecimento;

	public Item() {
		super();
	}

	public Item(Long codigoItem, Integer codigoDepartamento, List<ItemEstoque> estoqueEstabelecimento) {
		super();
		this.codigoItem = codigoItem; 
		this.codigoDepartamento = codigoDepartamento;
		this.estoqueEstabelecimento = estoqueEstabelecimento;
	}
	
	public Long getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(Long codigoItem) {
		this.codigoItem = codigoItem;
	}

	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(Integer codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public List<ItemEstoque> getEstoqueEstabelecimento() {
		return estoqueEstabelecimento;
	}

	public void setEstoqueEstabelecimento(List<ItemEstoque> estoqueEstabelecimento) {
		this.estoqueEstabelecimento = estoqueEstabelecimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoDepartamento == null) ? 0 : codigoDepartamento.hashCode());
		result = prime * result + ((codigoItem == null) ? 0 : codigoItem.hashCode());
		result = prime * result + ((estoqueEstabelecimento == null) ? 0 : estoqueEstabelecimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (codigoDepartamento == null) {
			if (other.codigoDepartamento != null)
				return false;
		} else if (!codigoDepartamento.equals(other.codigoDepartamento))
			return false;
		if (codigoItem == null) {
			if (other.codigoItem != null)
				return false;
		} else if (!codigoItem.equals(other.codigoItem))
			return false;
		if (estoqueEstabelecimento == null) {
			if (other.estoqueEstabelecimento != null)
				return false;
		} else if (!estoqueEstabelecimento.equals(other.estoqueEstabelecimento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [codigoItem=" + codigoItem + ", codigoDepartamento=" + codigoDepartamento
				+ ", estoqueEstabelecimento=" + estoqueEstabelecimento + "]";
	}
	
}
