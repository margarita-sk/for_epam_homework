package lesson3;

public class Task2 {

	public static void main(String[] args) {

		int number = 513143245;
		int a = 2;
		int b = 12;

		System.out.println("Max number: " + findMaxNumber(number));
		System.out.println(palindromCheck(number));
		System.out.println("Is it a prime number?: " + primeNumCheck(number));
		System.out.println(findPrimeDivisor(number));
		System.out.println("NOD: " + findNOD(a, b));
		System.out.println("NOK: " + findNOK(a, b));
		System.out.println("Quantity of different numbers: " + findQuantityDifferentNums(number));

	}

	private static int findMaxNumber(int number) {

		int max = 0;

		while (number > 0) {

			if (number % 10 > max) {
				max = number % 10;
			}
			number /= 10;

		}
		return max;
	}

	private static String palindromCheck(int number) {

		String answer = "It is a palindrome";
		StringBuilder check = new StringBuilder();
		check.append(number);

		for (int i = 0, j = check.length() - 1; i < check.length(); i++, j--) {
			if (check.charAt(i) != check.charAt(j)) {
				answer = "It isn't a palindrime";
			}
		}

		return answer;
	}

	private static boolean primeNumCheck(int number) {
		boolean answer = true;

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				answer = false;
			}
		}
		if (number < 2) {
			answer = false;
		}

		return answer;
	}

	private static String findPrimeDivisor(int number) {

		String answer = "Prime divisors of the number: ";

		for (int divisor = number - 1; divisor > 1; divisor--) {

			if (number % divisor == 0) {

				if (primeNumCheck(divisor)) {
					answer = answer + " " + divisor + " ";
				}
			}
		}
		return answer;
	}

	private static int findNOD(int a, int b) {
		int min = a;
		int nod = 1;

		if (a > b) {
			min = b;
		}
		for (int i = 1; i <= min; i++) {
			if ((a % i == 0) && (b % i == 0) && (i > nod)) {
				nod = i;
			}
		}

		return nod;
	}

	private static int findNOK(int a, int b) {
		int nok = a;
		if (a < b) {
			nok = b;
		}

		while ((nok % a != 0) || (nok % b != 0)) {
			nok++;
		}

		return nok;
	}

	private static int findQuantityDifferentNums(int number) {
		StringBuilder nums = new StringBuilder();

		while (number > 0) {
			nums.append(number % 10);
			number /= 10;
		}

		int differentNums = nums.length();

		outer: for (int i = 0; i < nums.length(); i++) {
			for (int j = i + 1; j < nums.length(); j++) {
				if (nums.charAt(i) == nums.charAt(j)) {
					differentNums--;
					continue outer;
				}
			}
		}
		return differentNums;
	}
}
