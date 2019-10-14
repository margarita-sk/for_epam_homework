package service;

import java.util.ArrayList;
import java.util.Collections;

import entity.Toy;
import entity.Toy.ChildsAge;
import entity.Toy.Size;
import entity.Toy.ToyTypes;
import service.CompareByOneParameter.Parameter;

public class ToyRoom {

	private ArrayList<Toy> roomToys = new ArrayList<Toy>();

	public ArrayList<Toy> createRoom(int roomCapacity, double totalCoast, ChildsAge childAge, ArrayList<Toy> toys) {
		double priceToys = 0.0;
		int counter = 0;

		for (Toy toy : toys) {
			if (totalCoast > priceToys && toy.getChildsage().equals(childAge) && roomCapacity > counter) {
				this.roomToys.add(toy);
				priceToys += toy.getPrice();
				counter++;
			}
		}
		return roomToys;
	}

	public void sortToys(Parameter parameter) {
		CompareByOneParameter comparator = new CompareByOneParameter(parameter);
		Collections.sort(this.roomToys, comparator);
		printToysOfRoom();
	}

	public void sortToysByPriceAndSize() {
		CompareByPriceAndSize comparator = new CompareByPriceAndSize();
		Collections.sort(this.roomToys, comparator);
		printToysOfRoom();
	}

	public Toy findToyByPrice(double price) {
		Toy toy = Factory.createToy(ToyTypes.BALL, price, ChildsAge.from0to3, Size.big);
		CompareByOneParameter compare = new CompareByOneParameter(Parameter.PRICE);
		for (Toy toyFromRoom : this.roomToys) {
			if (compare.compare(toyFromRoom, toy) == 0) {
				System.out.println("You are looking for: " + toyFromRoom);
				return toyFromRoom;
			}
		}
		System.out.println("There is no such toys...");
		return null;
	}

	public Toy findToyByType(ToyTypes type) {
		Toy toy = Factory.createToy(type, 0, ChildsAge.from0to3, Size.big);
		CompareByOneParameter compare = new CompareByOneParameter(Parameter.TYPE);
		for (Toy toyFromRoom : this.roomToys) {
			if (compare.compare(toyFromRoom, toy) == 0) {
				System.out.println("You are looking for: " + toyFromRoom);
				return toyFromRoom;
			}
		}
		System.out.println("There is no such toys...");
		return null;
	}

	public void printToysOfRoom() {
		for (Toy toy : this.roomToys) {
			System.out.println(toy.toString());
		}
	}

	public ArrayList<Toy> getRoomToys() {
		return roomToys;
	}

}
