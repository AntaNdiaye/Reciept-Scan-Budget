package directory.models;


import java.util.HashMap;
import java.util.List;

public class User {

	private String Name;
	private long Age;
	private long userId;
	private List<Receipt> userReceipts;

	private long month;


	/**
	 * adds this to "pastbudgetLimitMap"
	 */
	private double currentBudgetLimit;
	/**
	 * A hash map cannot contain duplicate keys; each key can map to at most one value.
	 * 
	 * Key = month - Long
	 * Value = amount - double
	 */
	private HashMap<Long,Double> pastBudgetLimitMap;
	/**
	 * A list of all of reciepts for a single user object
	 */


	public User(String name, long age, long userId, double currentBudgetLimit, HashMap<Long,Double> pastBudgetLimitMap, List<Receipt> userReciepts) {
		Name = name;
		Age = age;
		this.userId = userId;
		this.currentBudgetLimit = currentBudgetLimit;
		this.pastBudgetLimitMap = pastBudgetLimitMap;
		this.userReceipts = userReciepts;
	}

	public User() {

	}

	/**
	 * adds up the total of ALL reciepts per user
	 */
	public double getAllRecieptsTotal() {
		// TODO - implement User.getAllRecieptsTotal
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getAge() {
		return Age;
	}

	public void setAge(long age) {
		Age = age;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public double getCurrentBudgetLimit() {
		return currentBudgetLimit;
	}

	public void setCurrentBudgetLimit(double currentBudgetLimit) {
		this.currentBudgetLimit = currentBudgetLimit;
	}

	public HashMap<Long, Double> getPastBudgetLimitMap() {
		return pastBudgetLimitMap;
	}

	public long getMonth() { return month; }

	public void setMonth(long month) { this.month = month; }

	public void setPastBudgetLimitMap(HashMap<Long,Double> pastBudgetLimitMap) {
		this.pastBudgetLimitMap = pastBudgetLimitMap;
		pastBudgetLimitMap.put(month,getCurrentBudgetLimit());
	}

	public List<Receipt> getUserReciepts() {
		return userReceipts;
	}

	public void setUserReciepts(List<Receipt> userReciepts) {
		this.userReceipts = userReciepts;
	}

	@Override
	public String toString() {
		return "User{" +
				"Name='" + Name + '\'' +
				", Age=" + Age +
				", userId=" + userId +
				", currentBudgetLimit=" + currentBudgetLimit +
				", pastBudgetLimitMap=" + pastBudgetLimitMap +
				", userReciepts=" + userReceipts +
				'}';
	}
}