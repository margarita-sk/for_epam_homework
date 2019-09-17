package lesson1;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {

		int a = insertNumber();
		int b = insertNumber();
		int c = insertNumber();

		if (a == b && a == c) {
			System.out.println("Numbers are similar");
		} else {
			System.out.println("Numbers are different");
		}

	}

	static char number = 'a';

	static int insertNumber() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insert a number " + number + " ... ");
		int x = scanner.nextInt();

		number++;
		return x;
	}

}
