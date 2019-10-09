package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entity.Toy;
import entity.Toy.Size;

public class ToyRoom {

	private ArrayList<Toy> roomToys = new ArrayList<Toy>();

	public ArrayList<Toy> createRoom(int roomCapacity, double totalCoast, String childAge, ArrayList<Toy> toys) {
		double priceToys = 0.0;
		int counter = 0;

		for (Toy toy : toys) {
			if (totalCoast > priceToys && toy.getChildsage().name().equals(childAge) && roomCapacity > counter) {
				this.roomToys.add(toy);
				priceToys += toy.getPrice();
				counter++;
			}
		}
		return roomToys;
	}

	public void sortToysByPrice(int compare) {

		Comparator<Toy> comparator = new Comparator<Toy>() {
			@Override
			public int compare(Toy o1, Toy o2) {
				if (o1.getPrice() > o2.getPrice())
					return compare;
				if (o1.getPrice() < o2.getPrice())
					return compare * -1;
				return 0;
			}
		};
		Collections.sort(this.roomToys, comparator);
		printToysOfRoom();
	}

	public void sortToysBySize(int compare) {

		Comparator<Toy> comparator = new Comparator<Toy>() {

			@Override
			public int compare(Toy o1, Toy o2) {
				if (o1.getSize().ordinal() > o2.getSize().ordinal())
					return compare;
				if (o1.getSize().ordinal() < o2.getSize().ordinal())
					return compare * -1;
				return 0;
			}
		};
		Collections.sort(this.roomToys, comparator);
		printToysOfRoom();
	}

	public void sortToysBySizeAndPrice(int compare) {
		Comparator<Toy> comparator = new Comparator<Toy>() {

			@Override
			public int compare(Toy o1, Toy o2) {
				if (o1.getPrice() > o2.getPrice())
					return compare;
				else if (o1.getPrice() < o2.getPrice())
					return compare * -1;
				else {
					if (o1.getSize().ordinal() > o2.getSize().ordinal())
						return compare;
					if (o1.getSize().ordinal() < o2.getSize().ordinal())
						return compare * -1;
					return 0;
				}
			}
		};

		Collections.sort(this.roomToys, comparator);
		printToysOfRoom();
	}

	public Toy findCurrentToy(double price, String size) {
		Toy currentToy = new Toy(price, Size.valueOf(size)) {
		};

		for (Toy toy : this.roomToys) {
			if (toy.equals(currentToy)) {
				System.out.println("You was looking for this toy: " + toy.toString());
				return toy;
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

	public Toy findCurrentToy(String typeClass) {

		for (Toy toy : this.roomToys) {
			if (toy.getClass().getSimpleName().equals(typeClass)) {
				System.out.println("You was looking for this toy: " + toy.toString());
				return toy;
			}
		}
		System.out.println("There is no such toys...");
		return null;

	}

	public ArrayList<Toy> getRoomToys() {
		return roomToys;
	}

	public void setRoomToys(ArrayList<Toy> roomToys) {
		this.roomToys = roomToys;
	}

}
