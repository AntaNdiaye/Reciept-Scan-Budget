package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table
public class Receipt {

	private double total;
	private @Id
	@GeneratedValue
	long recieptId;
	/**
	 * URL of captured image
	 */
	private String imageUrl;
	private String businessName;
	private int date;
	/**
	 * a list of individual items within a single reciept.
	 */
	private DataItem dataItemsList;
	private User userID;

	public Receipt(double total, long recieptId, String imageUrl, String businessName, int date, DataItem dataItemsList, User userID) {
		this.total = total;
		this.recieptId = recieptId;
		this.imageUrl = imageUrl;
		this.businessName = businessName;
		this.date = date;
		this.dataItemsList = dataItemsList;
		this.userID = userID;
	}

	public Receipt() {

	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getRecieptId() {
		return recieptId;
	}

	public void setRecieptId(long recieptId) {
		this.recieptId = recieptId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public DataItem getDataItemsList() {
		return dataItemsList;
	}

	public void setDataItemsList(DataItem dataItemsList) {
		this.dataItemsList = dataItemsList;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Receipt{" +
				"total=" + total +
				", recieptId=" + recieptId +
				", imageUrl='" + imageUrl + '\'' +
				", businessName='" + businessName + '\'' +
				", date=" + date +
				", dataItemsList=" + dataItemsList +
				", userID=" + userID +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Receipt receipt = (Receipt) o;
		return Double.compare(receipt.total, total) == 0 && recieptId == receipt.recieptId && date == receipt.date && imageUrl.equals(receipt.imageUrl) && businessName.equals(receipt.businessName) && dataItemsList.equals(receipt.dataItemsList) && userID.equals(receipt.userID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(total, recieptId, imageUrl, businessName, date, dataItemsList, userID);
	}
}