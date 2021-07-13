package Models;

public enum Categories {
	;

	private int FOOD;
	private int CLOTHING;
	private int EDUCATION;
	private int TRAVEL;
	private int ENTERTAINMENT;
	private int MEDICAL;
	private int HOME;

	Categories(int FOOD, int CLOTHING, int EDUCATION, int TRAVEL, int ENTERTAINMENT, int MEDICAL, int HOME) {
		this.FOOD = FOOD;
		this.CLOTHING = CLOTHING;
		this.EDUCATION = EDUCATION;
		this.TRAVEL = TRAVEL;
		this.ENTERTAINMENT = ENTERTAINMENT;
		this.MEDICAL = MEDICAL;
		this.HOME = HOME;
	}

	public int getFOOD() {
		return FOOD;
	}

	public void setFOOD(int FOOD) {
		this.FOOD = FOOD;
	}

	public int getCLOTHING() {
		return CLOTHING;
	}

	public void setCLOTHING(int CLOTHING) {
		this.CLOTHING = CLOTHING;
	}

	public int getEDUCATION() {
		return EDUCATION;
	}

	public void setEDUCATION(int EDUCATION) {
		this.EDUCATION = EDUCATION;
	}

	public int getTRAVEL() {
		return TRAVEL;
	}

	public void setTRAVEL(int TRAVEL) {
		this.TRAVEL = TRAVEL;
	}

	public int getENTERTAINMENT() {
		return ENTERTAINMENT;
	}

	public void setENTERTAINMENT(int ENTERTAINMENT) {
		this.ENTERTAINMENT = ENTERTAINMENT;
	}

	public int getMEDICAL() {
		return MEDICAL;
	}

	public void setMEDICAL(int MEDICAL) {
		this.MEDICAL = MEDICAL;
	}

	public int getHOME() {
		return HOME;
	}

	public void setHOME(int HOME) {
		this.HOME = HOME;
	}
}