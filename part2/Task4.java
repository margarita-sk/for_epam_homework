package lesson3;

public class Task4 {

	public static void main(String[] args) {

		int a = 1;
		int b = 10_000;

		System.out.println(checkFriendlyNums(a, b));

	}

	private static String checkFriendlyNums(int a, int b) {
		String answer = new String();
		for (int i = a; i <= b; i++) {
			for (int j = i + 1; j <= b; j++) {
				if ((findSum(i) == j) && (findSum(j) == i)) {
					answer = answer + "These numbers are friendly: " + i + " and " + j + "\n";
				}
			}
		}
		if (answer.isEmpty()) {
			answer = "There aren't friendly numbers";
		}
		return answer;
	}

	private static int findSum(int number) {
		int sum = 0;

		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}

}
