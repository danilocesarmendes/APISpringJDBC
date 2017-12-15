package br.com.lojadomecanico.dto;

import java.util.List;

import br.com.lojadomecanico.model.Item;

public class ItemDTO {
	private List<Item> content;
	private Integer totalElements;
	private Integer batchNumber;
	
	public ItemDTO(List<Item> content, Integer totalElements, Integer batchNumber) {
		super();
		this.content = content;
		this.totalElements = totalElements;
		this.batchNumber = batchNumber;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(Integer batchNumber) {
		this.batchNumber = batchNumber;
	}

	public List<Item> getContent() {
		return content;
	}

	public void setContent(List<Item> content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchNumber == null) ? 0 : batchNumber.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((totalElements == null) ? 0 : totalElements.hashCode());
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
		ItemDTO other = (ItemDTO) obj;
		if (batchNumber == null) {
			if (other.batchNumber != null)
				return false;
		} else if (!batchNumber.equals(other.batchNumber))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (totalElements == null) {
			if (other.totalElements != null)
				return false;
		} else if (!totalElements.equals(other.totalElements))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemDTO [content=" + content + ", totalElements=" + totalElements + ", batchNumber=" + batchNumber
				+ "]";
	}

	
	
}
