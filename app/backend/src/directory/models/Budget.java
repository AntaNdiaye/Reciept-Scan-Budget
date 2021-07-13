package directory.models;

import java.util.Objects;

public class Budget {

	private int Date;
	private int budget;
	private long month;
	private double amount;
	private Enums.Notification notification;

	public Budget(int date, int budget, long month, double amount, Enums.Notification notification) {
		Date = date;
		this.budget = budget;
		this.month = month;
		this.amount = amount;
		this.notification = notification;
	}

	public int getDate() {
		return Date;
	}

	public void setDate(int date) {
		Date = date;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public long getMonth() {
		return month;
	}

	public void setMonth(long month) {
		this.month = month;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Enums.Notification getNotification() {
		return notification;
	}

	public void setNotification(Enums.Notification notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "Budget{" +
				"Date=" + Date +
				", budget=" + budget +
				", month=" + month +
				", amount=" + amount +
				", notification=" + notification +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Budget budget1 = (Budget) o;
		return Date == budget1.Date && budget == budget1.budget && month == budget1.month && Double.compare(budget1.amount, amount) == 0 && notification == budget1.notification;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Date, budget, month, amount, notification);
	}
}