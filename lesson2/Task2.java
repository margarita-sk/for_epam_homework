package lesson2;

import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("How old is your dragon?  ");
		int age = scanner.nextInt();
		scanner.close();

		int heads;

		if (age < 200) {
			heads = 3 + age * 3;
		} else {
			if (age < 300) {
				heads = 3 + 200 * 3 + (age - 200) * 2;
			} else {
				heads = 3 + 200 * 3 + 100 * 2 + (age - 300);
			}
		}

		int eyes = heads * 2;

		System.out.println("This dragon has " + heads + " heads and " + eyes + " eyes.");

	}

}
