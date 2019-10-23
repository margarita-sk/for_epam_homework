package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import entity.Toy;
import enums.AgeTypes;
import enums.Parameter;
import enums.ToyTypes;
import service.Factory;
import service.ToyRoom;
import sources.ReaderSource;

public class MenuService {

	public static final Logger LOGGER = Logger.getLogger(MenuService.class);

	static File file = new File("D:\\workspace\\HomeworkPart4\\text.txt");
	Scanner scanner = new Scanner(System.in);
	private ToyRoom room;

	public ToyRoom getRoom() {
		return room;
	}

	public ToyRoom createToyRoom() {
		try {
			AgeTypes type = null;

			System.out.println("Enter the parameters of the room please ");
			System.out.println("Enter the maximum number of toys the room can accommodate ... ");
			int maxToysNumberInRoom = scanner.nextInt();
			System.out.println("Enter the maximum cost of all toys in the room ... ");
			double maxToysCostInRoom = scanner.nextDouble();
			System.out.println("Enter the age limit of the room");
			System.out.println("For children from 0 to 3 years old ... enter ... 1");
			System.out.println("For children from 4 to 7 years old ... enter ... 2");
			System.out.println("For children from 8 to 18 years old ... enter ... 3");
			int ageType = scanner.nextInt();

			switch (ageType) {
			case 1:
				type = AgeTypes.FROM0TO3;
				break;
			case 2:
				type = AgeTypes.FROM4TO7;
				break;
			case 3:
				type = AgeTypes.FROM8TO18;
				break;
			default:
				System.out.println("Please, enter correct parameters!");
				createToyRoom();
			}
			this.room = Factory.createToyRoom(maxToysNumberInRoom, maxToysCostInRoom, type);
		} catch (InputMismatchException e) {
			LOGGER.warn("Wrong parameters", e);
			System.out.println("Please, enter correct parameters!");
			scanner.nextLine();
			createToyRoom();
		}
		return room;
	}

	public ToyRoom fillRoomWithToys() {
		ReaderSource reader = new ReaderSource();
		ArrayList<Toy> toys = reader.readToysFromFile(file);
		this.room.fillRoomWithToys(toys);
		return room;
	}

	public void sortToys() {
		System.out.println("Sort toys by price enter ... 1");
		System.out.println("Sort toys by size enter ... 2");
		System.out.println("Sort toys by size and price enter ... 3");

		switch (CommandChecker.checkCommand(4)) {
		case 1:
			this.room.sortToys(Parameter.PRICE);
			LOGGER.info("Sorted by price");
			break;
		case 2:
			this.room.sortToys(Parameter.SIZE);
			LOGGER.info("Sorted by size");
			break;
		case 3:
			this.room.sortToysByPriceAndSize();
			LOGGER.info("Sorted by size and price");
			break;
		default:
			System.out.println("You have entered wrong command!");
			sortToys();
		}
	}

	public void findToys() {
		System.out.println("If you want to search toys by type enter ... 1");
		System.out.println("If you want to search toys by price enter ... 2");

		switch (CommandChecker.checkCommand(2)) {
		case 1:
			System.out.println("Search dolls ... enter ... 1");
			System.out.println("Search cubes ... enter ... 2");
			System.out.println("Search balls ... enter ... 3");
			System.out.println("Search cars ... enter ... 4");
			ToyTypes type = null;

			switch (CommandChecker.checkCommand(4)) {
			case 1:
				type = ToyTypes.DOLL;
				break;
			case 2:
				type = ToyTypes.CUBE;
				break;
			case 3:
				type = ToyTypes.BALL;
				break;
			case 4:
				type = ToyTypes.TOYCAR;
				break;
			default:
				System.out.println("You have entered wrong command!");
				findToys();
			}
			System.out.println(this.room.findToyByType(type).toString());
			LOGGER.info("Search by type: " + type);
			break;

		case 2:
			System.out.println("Enter min price ... ");
			double min = scanner.nextDouble();
			System.out.println("Enter max price ... ");
			double max = scanner.nextDouble();
			System.out.println(this.room.findToyByPrice(min, max).toString());
			LOGGER.info("Search by price. Min: " + min + " Max: " + max);
			break;
		default:
			System.out.println("You have entered wrong command!");
			findToys();
		}
	}

}
