package controller;

public class selectCount {
	private String positionCode;
	private String count;
	

	public selectCount(String pc, String c) {
		positionCode = pc;
		count = c;
		// TODO Auto-generated constructor stub
	}

	String getCount() {
		return count;
	}

	void setCount(String count) {
		this.count = count;
	}

	/**
	 * @return the positionCode
	 */
	String getPositionCode() {
		return positionCode;
	}

	/**
	 * @param positionCode
	 *            the positionCode to set
	 */
	void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

}
