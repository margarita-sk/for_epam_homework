package part3;

public class Actions {

	double[][] fillArray(double[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.random() * 100;
			}
		}

		return array;
	}

	void findMaxNumber(double[][] array) {
		double max = 0;

		for (double[] arr : array) {
			for (double element : arr) {
				if (element > max) {
					max = element;
				}
			}
		}

		System.out.println("Max number:  " + max);
	}

	void findMinNumber(double[][] array) {
		double min = Math.pow(2, 64);

		for (double[] arr : array) {
			for (double element : arr) {
				if (element < min) {
					min = element;
				}
			}
		}

		System.out.println("Min number:  " + min);
	}

	void findMeanArithmetical(double[][] array) {

		double meanArithmetical = 0;

		for (double[] arr : array) {
			for (double element : arr) {
				meanArithmetical = meanArithmetical + element;
			}
		}
		meanArithmetical = meanArithmetical / (array.length * array[0].length);

		System.out.println("Arithmetical mean:  " + meanArithmetical);
	}

	void findMeanGeometrical(double[][] array) {
		double meanGeometrical = 0;

		for (double[] arr : array) {
			for (double element : arr) {
				meanGeometrical *= element;
			}
		}

		meanGeometrical = Math.pow(meanGeometrical, 1.0 / (array.length * array[0].length));
		System.out.println("Geometrical mean:  " + meanGeometrical);
	}

	double findLocalMin(double[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				double x = array[i][j];

				if (i == 0) {
					if (j == 0) {
						if (x < array[i + 1][j + 1] && x < array[i + 1][j] && x < array[i][j + 1]) {
							return array[i][j];
						}
					} else if (j == array[i].length - 1) {
						if (x < array[i][j - 1] && x < array[i + 1][j] && x < array[i + 1][j - 1]) {
							return array[i][j];
						}
					} else {
						if (x < array[i][j - 1] && x < array[i + 1][j + 1] && x < array[i + 1][j]
								&& x < array[i + 1][j - 1] && x < array[i][j + 1]) {
							return array[i][j];
						}
					}
				} else if (j == 0) {
					if (i == array.length - 1) {
						if (x < array[i - 1][j + 1] && x < array[i][j + 1] && x < array[i - 1][j]) {
							return array[i][j];
						}
					} else {

					}
				} else if (i == array.length - 1) {
					if (j == array[i].length - 1) {
						if (x < array[i - 1][j - 1] && x < array[i][j - 1] && x < array[i - 1][j]) {
							return array[i][j];
						}
					} else {
						if (x < array[i - 1][j - 1] && x < array[i][j - 1] && x < array[i + 1][j + 1]
								&& x < array[i - 1][j + 1] && x < array[i][j + 1] && x < array[i - 1][j]) {
							return array[i][j];
						}
					}
				} else if (j == array[i].length - 1) {
					if (x < array[i - 1][j - 1] && x < array[i][j - 1] && x < array[i + 1][j] && x < array[i + 1][j - 1]
							&& x < array[i - 1][j]) {
						return array[i][j];
					}
				} else {
					if (x < array[i - 1][j - 1] && x < array[i][j - 1] && x < array[i + 1][j + 1] && x < array[i + 1][j]
							&& x < array[i - 1][j + 1] && x < array[i + 1][j - 1] && x < array[i][j + 1]
							&& x < array[i - 1][j]) {
						return array[i][j];
					}
				}
			}
		}
		return -1;
	}

	double findLocalMax(double[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				double x = array[i][j];

				if (i == 0) {
					if (j == 0) {
						if (x > array[i + 1][j + 1] && x > array[i + 1][j] && x > array[i][j + 1]) {
							return array[i][j];
						}
					} else if (j == array[i].length - 1) {
						if (x > array[i][j - 1] && x > array[i + 1][j] && x > array[i + 1][j - 1]) {
							return array[i][j];
						}
					} else {
						if (x > array[i][j - 1] && x > array[i + 1][j + 1] && x > array[i + 1][j]
								&& x > array[i + 1][j - 1] && x > array[i][j + 1]) {
							return array[i][j];
						}
					}
				} else if (j == 0) {
					if (i == array.length - 1) {
						if (x > array[i - 1][j + 1] && x > array[i][j + 1] && x > array[i - 1][j]) {
							return array[i][j];
						}
					} else {

					}
				} else if (i == array.length - 1) {
					if (j == array[i].length - 1) {
						if (x > array[i - 1][j - 1] && x > array[i][j - 1] && x > array[i - 1][j]) {
							return array[i][j];
						}
					} else {
						if (x > array[i - 1][j - 1] && x > array[i][j - 1] && x > array[i + 1][j + 1]
								&& x > array[i - 1][j + 1] && x > array[i][j + 1] && x > array[i - 1][j]) {
							return array[i][j];
						}
					}
				} else if (j == array[i].length - 1) {
					if (x > array[i - 1][j - 1] && x > array[i][j - 1] && x > array[i + 1][j] && x > array[i + 1][j - 1]
							&& x > array[i - 1][j]) {
						return array[i][j];
					}
				} else {
					if (x > array[i - 1][j - 1] && x > array[i][j - 1] && x > array[i + 1][j + 1] && x > array[i + 1][j]
							&& x > array[i - 1][j + 1] && x > array[i + 1][j - 1] && x > array[i][j + 1]
							&& x > array[i - 1][j]) {
						return array[i][j];
					}
				}
			}
		}
		return -1;
	}

	double[][] transposeMatrix(double[][] array) {
		double temp;

		if (array.length == array[0].length) {
			for (int i = 0; i < array.length; i++) {
				for (int j = i + 1; j < array[i].length; j++) {
					temp = array[i][j];
					array[i][j] = array[j][i];
					array[j][i] = temp;
				}
			}
			return array;
		} else {
			double[][] array2 = new double[array[0].length][array.length];
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[0].length; j++) {
					array2[j][i] = array[i][j];
				}
			}
			return array2;
		}
	}

}
