package lesson2;

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert a symbol, please.   ");
		char letter = scanner.next().charAt(0);
		scanner.close();

		System.out.println(firstChecker(letter));
		System.out.println(secondChecker(letter));
		System.out.println(thirdCheker(letter));
		System.out.println(fourthCheker(letter));
	}

//1
	private static String firstChecker(char letter) {

		String answer = "It isn't a vowel letter.";
		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };

		for (char a : vowels) {
			if (letter == a) {
				answer = "It is a vowel letter.";
			}
		}
		return answer;
	};

//2
	private static String secondChecker(char letter) {
		String answer = "It isn't a vowel letter.";
		switch (letter) {
		case 'A':
		case 'a':
		case 'E':
		case 'e':
		case 'I':
		case 'i':
		case 'O':
		case 'o':
		case 'U':
		case 'u':
			answer = "It is a vowel letter.";
			break;

		default:
			break;
		}
		return answer;
	}

//3
	private static String thirdCheker(char letter) {
		String answer = "It isn't a vowel letter.";

		if (letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i' || letter == 'I'
				|| letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U') {
			answer = "It is a vowel letter.";
		}

		return answer;
	}

//4
	private static String fourthCheker(char letter) {
		String answer = "It isn't a vowel letter.";
		String vowel = "AEIOUaeiou";

		int index = vowel.indexOf(letter);
		if (index >= 0) {
			answer = "It is a vowel letter.";
		}
		return answer;
	}
}
