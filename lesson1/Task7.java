package lesson1;

import java.util.Scanner;

public class Task7 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Insert number a: ");
		int a = scanner.nextInt();
		System.out.println("Insert number b: ");
		int b = scanner.nextInt();
		scanner.close();

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("a = " + a);
		System.out.println("b = " + b);

	}

}
