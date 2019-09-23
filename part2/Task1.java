package lesson3;

import java.util.Random;

public class Task1 {

	public static void main(String[] args) {

		Random random = new Random();
		int tosNum = 1000;

		System.out.println(tossСoin(random, tosNum));

	}

	private static String tossСoin(Random random, int tosNum) {
		int headsNum = 0;
		int tailsNum = 0;

		for (int i = 0; i < tosNum; i++) {
			boolean coin = random.nextBoolean();

			if (coin) {
				headsNum++;
			} else {
				tailsNum++;
			}
		}
		return "Heads fell " + headsNum + " times, and tails fell " + tailsNum + " times.";

	}

}
