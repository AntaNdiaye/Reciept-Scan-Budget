package directory.models;

import javax.persistence.Entity;

@Entity
public class User {

	private String Name;
	private long Age;
	private long userId;

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
	private int pastBudgetLimitMap;
	/**
	 * A list of all of reciepts for a single user object
	 */
	private Receipt userReciepts;

	public User(String name, long age, long userId, double currentBudgetLimit, int pastBudgetLimitMap, Receipt userReciepts) {
		Name = name;
		Age = age;
		this.userId = userId;
		this.currentBudgetLimit = currentBudgetLimit;
		this.pastBudgetLimitMap = pastBudgetLimitMap;
		this.userReciepts = userReciepts;
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

	public int getPastBudgetLimitMap() {
		return pastBudgetLimitMap;
	}

	public void setPastBudgetLimitMap(int pastBudgetLimitMap) {
		this.pastBudgetLimitMap = pastBudgetLimitMap;
	}

	public Receipt getUserReciepts() {
		return userReciepts;
	}

	public void setUserReciepts(Receipt userReciepts) {
		this.userReciepts = userReciepts;
	}

	@Override
	public String toString() {
		return "User{" +
				"Name='" + Name + '\'' +
				", Age=" + Age +
				", userId=" + userId +
				", currentBudgetLimit=" + currentBudgetLimit +
				", pastBudgetLimitMap=" + pastBudgetLimitMap +
				", userReciepts=" + userReciepts +
				'}';
	}
}