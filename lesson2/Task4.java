package lesson2;

import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert first number, please... ");
		int firstNumber = scanner.nextInt();
		System.out.println("Insert second number, please... ");
		int secondNumber = scanner.nextInt();
		System.out.println("Insert third number, please... ");
		int thirdNumber = scanner.nextInt();
		scanner.close();

		String date = firstNumber + 1 + "." + secondNumber + "." + thirdNumber;

//february
		if (secondNumber == 2) {
			if (firstNumber >= 28) {
				if (checkLeapYear(thirdNumber) == true) {
					if (firstNumber == 29) {
						date = 01 + "." + 3 + "." + thirdNumber;
					}
				} else {
					if (firstNumber == 28) {
						date = 01 + "." + 3 + "." + thirdNumber;
					}
				}
			}

// december
		} else if (secondNumber == 12) {
			if (firstNumber == 31) {
				date = 01 + "." + 01 + "." + ++thirdNumber;
			}

// months with 31 days
		} else if (secondNumber == 1 || secondNumber == 3 || secondNumber == 5 || secondNumber == 7 || secondNumber == 8
				|| secondNumber == 10) {
			if (firstNumber == 31) {
				date = 01 + "." + secondNumber + 1 + "." + thirdNumber;
			}

// months with 30 days
		} else {
			if (firstNumber == 30) {
				date = 01 + "." + secondNumber + 1 + "." + thirdNumber;
			}
		}

		System.out.println("Next date is " + date);
	}

	private static boolean checkLeapYear(int thirdNumber) {

		if (thirdNumber % 4 == 0) {
			if (thirdNumber % 100 == 0) {
				if (thirdNumber % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

}
