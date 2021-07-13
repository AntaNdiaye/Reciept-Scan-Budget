package Models;

import java.util.Objects;

public class DataItem {

	private String itemName;
	private Enums.Categories categories;
	private double itemPrice;

	public DataItem(String itemName, Enums.Categories categories, double itemPrice) {
		this.itemName = itemName;
		this.categories = categories;
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Enums.Categories getCategory() {
		return categories;
	}

	public void setCategory(Enums.Categories category) {
		this.categories = category;
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
		return Objects.hash(itemName, categories, itemPrice);
	}

	@Override
	public String toString() {
		return "DataItem{" +
				"itemName='" + itemName + '\'' +
				", category=" + categories +
				", itemPrice=" + itemPrice +
				'}';
	}
}