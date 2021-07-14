package directory.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	private String name;
	private long age;

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
	@OneToMany(mappedBy = "user")
	private List<Receipt> userReciepts;

	public User(String name, long age, long userId, double currentBudgetLimit, int pastBudgetLimitMap) {
		this.name = name;
		this.age = age;
		this.userId = userId;
		this.currentBudgetLimit = currentBudgetLimit;
		this.pastBudgetLimitMap = pastBudgetLimitMap;
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
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

	public List<Receipt> getUserReciepts() {
		return userReciepts;
	}

	public void setUserReciepts(List<Receipt> userReciepts) {
		this.userReciepts = userReciepts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return age == user.age && userId == user.userId && Double.compare(user.currentBudgetLimit, currentBudgetLimit) == 0 && pastBudgetLimitMap == user.pastBudgetLimitMap && Objects.equals(name, user.name) && Objects.equals(userReciepts, user.userReciepts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, userId, currentBudgetLimit, pastBudgetLimitMap, userReciepts);
	}
}