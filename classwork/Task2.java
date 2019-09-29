package classwork;

import java.util.Random;

public class Task2 {

	public static void main(String[] args) {

//		 хардкод для проверки

//		int radius = 4;
//		int x1 = 3;
//		int y1 = -4;
//		int x2 = 5;
//		int y2 = 1;
//		chekInCircle(x1, y1, radius);
//		chekInCircle(x2, y2, radius);
//		System.out.println("Количество точек, которые не попали в круг = " + counter);

		createRandomAll();
	}

	static int counter = 0;

	private static int chekInCircle(int x, int y, int radius) {

		if (Math.pow(radius, 2) < (Math.pow(x, 2) + Math.pow(y, 2))) {
			counter++;
		}

		return counter;
	}

	private static int generateNumber() {
		Random random = new Random();
		int numberRandom = random.nextInt(30 + 10) - 10;
		return numberRandom;
	}

	private static void createRandomAll() {
		int radius = generateNumber();
		System.out.println("Задан радиус: " + radius);

		int numberOfDots = 0;
		while (numberOfDots < 1) {
			numberOfDots = (int) (Math.random() * 10);
		}

		System.out.println("Задано количество точек: " + numberOfDots);

		for (int i = 0; i < numberOfDots; i++) {
			int n1 = generateNumber();
			int n2 = generateNumber();
			System.out.println("Точки координат " + n1 + "    " + n2);
			chekInCircle(n1, n2, radius);
		}
		System.out.println("Количество точек, которые не попали в круг = " + counter);
	}

}
