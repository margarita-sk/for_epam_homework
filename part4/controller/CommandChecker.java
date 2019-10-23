package controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class CommandChecker {
	static Scanner scanner = new Scanner(System.in);
	static int choice;
	private static final Logger LOGGER = Logger.getLogger(Menu.class);

	public static int checkCommand(int countOfChoice) {
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("Write a correct command, please!");
				LOGGER.warn("attempt to enter the wrong command");
				scanner.nextLine();
			}
			choice = scanner.nextInt();
		} while ((choice < 0) && (choice > countOfChoice));
		return choice;
	}

}
