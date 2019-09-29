package part3;

public class Arrays {

	private double[][] hardCode1 = new double[][] { { 4, 3, 4 }, { 4, 2, 9 }, { 3, 8, 3 } };
	private double[][] hardCode2 = new double[][] { { 8, 2, 11, 2 }, { 223, 2, 5, 444 }, { 543, 0, 54, 3 },
			{ 123, 34, 1, 5 } };

	public double[][] createEmptyRandomArray() {
		int n = 0;
		int m = 0;
		do {
			n = (int) (Math.random() * 10);
			m = (int) (Math.random() * 10);
		} while ((n < 2) && (m < 2));
		double[][] array = new double[n][m];
		return array;
	}

	public double[][] getHardCode1() {
		return hardCode1;
	}

	public double[][] getHardCode2() {
		return hardCode2;
	}

	public void printArray(double[][] array) {
		for (double[] arr : array) {
			for (double element : arr) {
				System.out.print(element + "   ");
			}
			System.out.println();

		}
	}

}
