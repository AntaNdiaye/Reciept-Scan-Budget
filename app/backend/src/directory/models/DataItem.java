package directory.models;

public class DataItem implements Enums{

	private String itemName;
	private Enums.Categories categories;
	private double itemPrice;
	private String dataItemId;

	public DataItem() {

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