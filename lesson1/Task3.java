package lesson1;

import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Insert diameter of first circle: ");
		int r1 = scanner.nextInt();
		System.out.println("Insert diameter of second circle: ");
		int r2 = scanner.nextInt();

		if (r1 > r2) {
			double sRing = (Math.PI * Math.pow(r1, 2)) - (Math.PI * Math.pow(r2, 2));
			System.out.println("A Sqare of a ring: " + sRing);
		} else {
			System.out.println("You have inserted wrong numbers");
		}

		scanner.close();

	}

}
