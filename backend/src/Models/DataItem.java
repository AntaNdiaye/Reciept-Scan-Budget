package Models;

import java.util.Objects;

public class DataItem {

	private String itemName;
	private Categories category;
	private double itemPrice;

	public DataItem(String itemName, Categories category, double itemPrice) {
		this.itemName = itemName;
		this.category = category;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DataItem dataItem = (DataItem) o;
		return Double.compare(dataItem.itemPrice, itemPrice) == 0 && itemName.equals(dataItem.itemName) && category == dataItem.category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemName, category, itemPrice);
	}

	@Override
	public String toString() {
		return "DataItem{" +
				"itemName='" + itemName + '\'' +
				", category=" + category +
				", itemPrice=" + itemPrice +
				'}';
	}
}