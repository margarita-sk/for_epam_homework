package service;

import java.io.File;
import java.util.ArrayList;
import entity.Toy;
import entity.Toy.ChildsAge;
import entity.Toy.ToyTypes;
import service.CompareByOneParameter.Parameter;
import sources.ReaderSource;

public class Main {

	public static void main(String[] args) throws Exception {

		File file = new File("D:\\workspace\\HomeworkPart4\\text.txt");
//		File wrongFile = new File("D:\\workspace\\HomeworkPart4\\wrong.txt");
		ReaderSource reader = new ReaderSource();
		ArrayList<Toy> toys = reader.readToysFromFile(file);

		ToyRoom room1 = new ToyRoom();
		room1.createRoom(7, 3000.0, ChildsAge.from0to3, toys);
		room1.printToysOfRoom();
//		room1.findToyByPrice(120.3);
//		room1.findToyByType(ToyTypes.CUBE);
//		room1.sortToys(Parameter.PRICE);
//		room1.sortToys(Parameter.SIZE);
//		room1.sortToys(Parameter.TYPE);
//		room1.sortToysByPriceAndSize();

	}
}