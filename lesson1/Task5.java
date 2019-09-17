package lesson1;

import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert number: ");
		int number = scanner.nextInt();
		scanner.close();

		int[] num = new int[6];

		int sum = 0;
		int product = 1;

		for (int i = 0; i < 6; i++) {
			num[i] = number % 10;
			number = number / 10;

			sum = sum + num[i];
			product = product * num[i];
		}

		System.out.println(sum + "    " + product);

		int arithmeticMean = sum / 6;
		double geometricMean = Math.pow(product, 1 / 6.0);

		System.out.println("Arithmetic mean: " + arithmeticMean);
		System.out.println("Geometric mean: " + geometricMean);

	}

}
