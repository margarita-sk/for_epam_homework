package service;

import java.util.ArrayList;
import java.util.Collections;

import comparator.CompareByOneParameter;
import comparator.CompareByPriceAndSize;
import entity.Toy;
import enums.Parameter;
import enums.ToyTypes;
import enums.AgeTypes;

public class ToyRoom {

	private int maxNumberOfToys;
	private int numberOfToys;
	private double maxCostToysInRoom;
	private double costToysInRoom;
	private AgeTypes ageType;
	private ArrayList<Toy> roomToys = new ArrayList<Toy>();

	public ArrayList<Toy> fillRoomWithToys(ArrayList<Toy> toys) {
		for (Toy toy : toys) {
			if ((this.maxCostToysInRoom >= (costToysInRoom + toy.getPrice())) && (this.maxNumberOfToys > numberOfToys)
					&& (this.ageType.equals(toy.getAgeType()))) {
				roomToys.add(toy);
				this.costToysInRoom += toy.getPrice();
				this.numberOfToys++;
			}
		}
		return roomToys;
	}

	public void sortToys(Parameter parameter) {
		CompareByOneParameter comparator = new CompareByOneParameter(parameter);
		Collections.sort(this.roomToys, comparator);
	}

	public void sortToysByPriceAndSize() {
		CompareByPriceAndSize comparator = new CompareByPriceAndSize();
		Collections.sort(this.roomToys, comparator);
	}

	public ArrayList<Toy> findToyByPrice(double minPrice, double maxPrice) {
		ArrayList<Toy> toysBySearch = new ArrayList<Toy>();
		for (Toy toyFromRoom : this.roomToys) {
			if ((toyFromRoom.getPrice() >= minPrice) && (toyFromRoom.getPrice() <= maxPrice)) {
				toysBySearch.add(toyFromRoom);
			}
		}
		return toysBySearch;
	}

	public ArrayList<Toy> findToyByType(ToyTypes type) {
		ArrayList<Toy> toysBySearch = new ArrayList<Toy>();
		for (Toy toyFromRoom : this.roomToys) {
			if (toyFromRoom.getToyType().equals(type))
				toysBySearch.add(toyFromRoom);
		}
		return toysBySearch;
	}

	@Override
	public String toString() {
		String answer = new String();
		for (Toy toy : this.roomToys) {
			answer = answer + toy.toString() + "\n";
		}
		return answer;
	}

	public int getNumberOfToys() {
		return numberOfToys;
	}

	public void setNumberOfToys(int numberOfToys) {
		this.numberOfToys = numberOfToys;
	}

	public double getMaxCostToysInRoom() {
		return maxCostToysInRoom;
	}

	public void setMaxCostToysInRoom(double maxCostToysInRoom) {
		this.maxCostToysInRoom = maxCostToysInRoom;
	}

	public int getMaxNumberOfToys() {
		return maxNumberOfToys;
	}

	public void setMaxNumberOfToys(int maxNumberOfToys) {
		this.maxNumberOfToys = maxNumberOfToys;
	}

	public double getCostToysInRoom() {
		return costToysInRoom;
	}

	public void setCostToysInRoom(double costToysInRoom) {
		this.costToysInRoom = costToysInRoom;
	}

	public AgeTypes getAgeType() {
		return ageType;
	}

	public void setAgeType(AgeTypes ageType) {
		this.ageType = ageType;
	}

	public ArrayList<Toy> getRoomToys() {
		return roomToys;
	}

}
