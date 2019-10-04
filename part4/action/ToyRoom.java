package action;

import java.util.ArrayList;

import entity.Toy;

public class ToyRoom {

	private double totalCost;
	private String childAge;

	public ArrayList<Toy> createRoom(double totalCoast, String childAge, Toy[] toys) {
		double priceToys = 0;
		ArrayList<Toy> roomToys = new ArrayList<Toy>();
		for (int i = 0; totalCoast > priceToys; i++) {

			if (toys[i].getChildsage().equals(childAge)) {
				roomToys.add(toys[i]);
				priceToys += toys[i].getPrice();
			}
		}
		return roomToys;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getChildAge() {
		return childAge;
	}

	public void setChildAge(String childAge) {
		this.childAge = childAge;
	}

}
