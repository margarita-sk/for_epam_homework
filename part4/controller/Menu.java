package controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Menu {

	private static final Logger LOGGER = Logger.getLogger(Menu.class);
	private static MenuService menu = new MenuService();
	static Scanner scanner = new Scanner(System.in);
	static int choice;

	public static void loader() {
		System.out.println("If you want to create toy room enter ... 1");
		System.out.println("If you don't enter ... 2");

		switch (CommandChecker.checkCommand(2)) {
		case 1:
			menu.createToyRoom();
			LOGGER.info("The room had been created");
			fillRoom();
			break;
		case 2:
			System.out.println("Goodbye! See you later!");
			LOGGER.info("Exit");
			break;
		default:
			System.out.println("You have entered wrong command!");
			loader();
			break;
		}
	}

	public static void fillRoom() {
		System.out.println("Do you want to fill the room with toys?");
		System.out.println("Yes ... enter ... 1");
		System.out.println("No ... enter ... 2");

		switch (CommandChecker.checkCommand(2)) {
		case 1:
			menu.fillRoomWithToys();
			LOGGER.info("The room had been filled with toys");
			readCommand();
			break;
		case 2:
			LOGGER.info("Exit in loader");
			loader();
			break;
		default:
			System.out.println("You have entered wrong command!");
			fillRoom();
			break;
		}
	}

	public static void readCommand() {
		System.out.println("If you want to print toys enter ... 1");
		System.out.println("If you want to sort toys enter ... 2");
		System.out.println("If you want to find toys enter ... 3");
		System.out.println("If you want to exit enter ... 4");

		switch (CommandChecker.checkCommand(4)) {
		case 1:
			System.out.println(menu.getRoom().toString());
			LOGGER.info("Toys had been printed");
			readCommand();
			break;
		case 2:
			menu.sortToys();
			LOGGER.info("Sort toys");
			readCommand();
			break;
		case 3:
			menu.findToys();
			LOGGER.info("Search toys");
			readCommand();
			break;
		case 4:
			System.out.println("Goodbye! See you later!");
			LOGGER.info("Exit");
			break;
		default:
			System.out.println("You have entered wrong command!");
			readCommand();
			break;
		}
	}

}
