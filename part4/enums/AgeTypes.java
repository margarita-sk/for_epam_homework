package enums;

public enum AgeTypes {
	FROM0TO3(0, 3), FROM4TO7(4, 7), FROM8TO18(8, 18);

	private int min;
	private int max;

	private AgeTypes(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
}
