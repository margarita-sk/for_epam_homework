package lesson1;

import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Insert weight of dinosaur in kilograms: ");
		int dinosaurWeightKilogram = scanner.nextInt();

		int dinosaurWeightMilligram = dinosaurWeightKilogram * 1000_000;
		int dinosaurWeightGram = dinosaurWeightKilogram * 1000;
		double dinosaurWeightTon = dinosaurWeightKilogram * 0.001;

		System.out.println("Weight in miligrams: " + dinosaurWeightMilligram);
		System.out.println("Weight in grams: " + dinosaurWeightGram);
		System.out.println("Weight in tons: " + dinosaurWeightTon);

		scanner.close();
	}

}
