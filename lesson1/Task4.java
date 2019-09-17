package lesson1;

import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Insert a number... ");
		int number = scanner.nextInt();
		scanner.close();

		int[] num = new int[4];

		int count = 0;

		for (int i = 0; i < 4; i++) {
			num[i] = number % 10;
			number = number / 10;

			if (i > 0 && num[i] < num[i - 1]) {
				count++;
			} else if (i > 0 && num[i] > num[i - 1]) {
				count--;
			}

		}

		if (count == 3) {
			System.out.println("The sequence is increasing");
		} else if (count == -3) {
			System.out.println("The sequence is decreasing");
		} else {
			System.out.println("The sequence is niether increasing, nor decreasing");
		}

	}

}
