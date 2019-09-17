package lesson1;

import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Insert a number: ");
		int n = scanner.nextInt();
		scanner.close();

		int[] number = new int[7];
		int reversiveNumber = 0;

		int count = 1000_000;

		for (int i = 6; i >= 0; i--) {
			number[i] = n % 10;
			n = n / 10;

			reversiveNumber = reversiveNumber + number[i] * count;
			count = count / 10;

		}

		System.out.println("Reversive number: " + reversiveNumber);

	}

}
