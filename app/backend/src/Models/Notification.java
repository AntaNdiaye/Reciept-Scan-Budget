package Models;

public enum Notification {
	;

	private int OVER_BUDGET;
	private int REPEAT_PURCHASE;
	private int WITHIN_BUDGET;

	Notification(int OVER_BUDGET, int REPEAT_PURCHASE, int WITHIN_BUDGET) {
		this.OVER_BUDGET = OVER_BUDGET;
		this.REPEAT_PURCHASE = REPEAT_PURCHASE;
		this.WITHIN_BUDGET = WITHIN_BUDGET;
	}

	public int getOVER_BUDGET() {
		return OVER_BUDGET;
	}

	public void setOVER_BUDGET(int OVER_BUDGET) {
		this.OVER_BUDGET = OVER_BUDGET;
	}

	public int getREPEAT_PURCHASE() {
		return REPEAT_PURCHASE;
	}

	public void setREPEAT_PURCHASE(int REPEAT_PURCHASE) {
		this.REPEAT_PURCHASE = REPEAT_PURCHASE;
	}

	public int getWITHIN_BUDGET() {
		return WITHIN_BUDGET;
	}

	public void setWITHIN_BUDGET(int WITHIN_BUDGET) {
		this.WITHIN_BUDGET = WITHIN_BUDGET;
	}

	@Override
	public String toString() {
		return "Notification{" +
				"OVER_BUDGET=" + OVER_BUDGET +
				", REPEAT_PURCHASE=" + REPEAT_PURCHASE +
				", WITHIN_BUDGET=" + WITHIN_BUDGET +
				'}';
	}
}