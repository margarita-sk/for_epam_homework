package service;

import java.io.File;
import java.util.ArrayList;
import entity.Toy;

public class Main {

	public static void main(String[] args) {

//		ArrayList<Toy> toys = new ArrayList<Toy>();
//		toys.add(new Ball(150, ChildsAge.from0to3, Size.BIG));
//		toys.add(new Doll(150, ChildsAge.from0to3, Size.SMALL));
//		toys.add(new Cube(135, ChildsAge.from0to3, Size.MEDIUM));
//		toys.add(new ToyCar(100, ChildsAge.from0to3, Size.SMALL));

		File file = new File("D:\\workspace\\HomeworkPart4\\text.txt");
		Reader reader = new Reader();
		ArrayList<Toy> toys = reader.readToysFromFile(file);

		ToyRoom room1 = new ToyRoom();
		room1.createRoom(3, 15000.0, "from0to3", toys);
		room1.printToysOfRoom();

//		room1.sortToysBySize(-1); // 1 по возрастанию, -1 по убыванию
//		room1.sortToysByPrice(-1); // 1 по возрастанию, -1 по убыванию
//		room1.sortToysBySizeAndPrice(1); // 1 по возрастанию, -1 по убыванию
//		room1.findCurrentToy("Doll");
		room1.findCurrentToy(120.3, "small");

	}
}