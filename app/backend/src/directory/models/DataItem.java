package directory.models;

import javax.persistence.*;

@Entity
public class DataItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String itemName;
	private Enums.Categories categories;
	private double itemPrice;
	private String dataItemId;
	@ManyToOne
	private Receipt receipt;

	public DataItem() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getDataItemId() {
		return dataItemId;
	}

	public void setDataItemId(String dataItemId) {
		this.dataItemId = dataItemId;
	}
}