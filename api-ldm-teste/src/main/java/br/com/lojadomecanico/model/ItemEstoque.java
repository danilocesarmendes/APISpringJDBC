package br.com.lojadomecanico.model;

import java.sql.Date;

public class ItemEstoque {

	private Long codigoEstabelecimento;

	private Integer quantidade;

	private Date dataDisponivel;

	private Integer prazoDisponivel;

	private Integer quantidadeFisica;

	private Integer quantidadeAtenuada;

	private Long item;

	public ItemEstoque() {
		super();
	}

	public ItemEstoque(Long codigoEstabelecimento, Integer quantidade, Date dataDisponivel, Integer prazoDisponivel,
			Integer quantidadeFisica, Integer quantidadeAtenuada, Long item) {
		super();
		this.codigoEstabelecimento = codigoEstabelecimento;
		this.quantidade = quantidade;
		this.dataDisponivel = dataDisponivel;
		this.prazoDisponivel = prazoDisponivel;
		this.quantidadeFisica = quantidadeFisica;
		this.quantidadeAtenuada = quantidadeAtenuada;
		this.item = item;
	}

	public Long getCodigoEstabelecimento() {
		return codigoEstabelecimento;
	}

	public void setCodigoEstabelecimento(Long codigoEstabelecimento) {
		this.codigoEstabelecimento = codigoEstabelecimento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataDisponivel() {
		return dataDisponivel;
	}

	public void setDataDisponivel(Date dataDisponivel) {
		this.dataDisponivel = dataDisponivel;
	}

	public Integer getPrazoDisponivel() {
		return prazoDisponivel;
	}

	public void setPrazoDisponivel(Integer prazoDisponivel) {
		this.prazoDisponivel = prazoDisponivel;
	}

	public Integer getQuantidadeFisica() {
		return quantidadeFisica;
	}

	public void setQuantidadeFisica(Integer quantidadeFisica) {
		this.quantidadeFisica = quantidadeFisica;
	}

	public Integer getQuantidadeAtenuada() {
		return quantidadeAtenuada;
	}

	public void setQuantidadeAtenuada(Integer quantidadeAtenuada) {
		this.quantidadeAtenuada = quantidadeAtenuada;
	}

	public Long getItem() {
		return item;
	}

	public void setItem(Long item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEstabelecimento == null) ? 0 : codigoEstabelecimento.hashCode());
		result = prime * result + ((dataDisponivel == null) ? 0 : dataDisponivel.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((prazoDisponivel == null) ? 0 : prazoDisponivel.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((quantidadeAtenuada == null) ? 0 : quantidadeAtenuada.hashCode());
		result = prime * result + ((quantidadeFisica == null) ? 0 : quantidadeFisica.hashCode());
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
		ItemEstoque other = (ItemEstoque) obj;
		if (codigoEstabelecimento == null) {
			if (other.codigoEstabelecimento != null)
				return false;
		} else if (!codigoEstabelecimento.equals(other.codigoEstabelecimento))
			return false;
		if (dataDisponivel == null) {
			if (other.dataDisponivel != null)
				return false;
		} else if (!dataDisponivel.equals(other.dataDisponivel))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (prazoDisponivel == null) {
			if (other.prazoDisponivel != null)
				return false;
		} else if (!prazoDisponivel.equals(other.prazoDisponivel))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (quantidadeAtenuada == null) {
			if (other.quantidadeAtenuada != null)
				return false;
		} else if (!quantidadeAtenuada.equals(other.quantidadeAtenuada))
			return false;
		if (quantidadeFisica == null) {
			if (other.quantidadeFisica != null)
				return false;
		} else if (!quantidadeFisica.equals(other.quantidadeFisica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemEstoque [codigoEstabelecimento=" + codigoEstabelecimento + ", quantidade=" + quantidade
				+ ", dataDisponivel=" + dataDisponivel + ", prazoDisponivel=" + prazoDisponivel + ", quantidadeFisica="
				+ quantidadeFisica + ", quantidadeAtenuada=" + quantidadeAtenuada + ", item=" + item + "]";
	}

	public int intValue() {
		return codigoEstabelecimento.intValue();
	}

}
