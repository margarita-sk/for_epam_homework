package lesson3;

public class Task3 {
	public static void main(String[] args) {

		int number = 492;

		System.out.println(checkPerfectNumber(number));
	}

	private static String checkPerfectNumber(int number) {
		int sum = 0;
		String answer = "It isn't a perfect number";

		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum = sum + i;
			}
		}

		if (number == sum) {
			answer = "It's a perfect number";
		}

		return answer;
	}
}
