package directory.models;

import javax.persistence.*;

@Entity
public class DataItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dataItemId;

	@ManyToOne
	private Receipt receipt;

	private String itemName;
	private Enums.Categories categories;
	private Double itemPrice;

	public DataItem() {

	}

	public Long getDataItemId() {
		return dataItemId;
	}

	public void setDataItemId(Long dataItemId) {
		this.dataItemId = dataItemId;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Enums.Categories getCategories() {
		return categories;
	}

	public void setCategories(Enums.Categories categories) {
		this.categories = categories;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

}