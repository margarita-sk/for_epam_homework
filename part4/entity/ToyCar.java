package entity;

import enums.AgeTypes;
import enums.CarTypes;
import enums.Size;
import enums.ToyTypes;
import service.ToyAction;

public class ToyCar extends Toy implements ToyAction {

	public ToyCar(ToyTypes toyType, double price, AgeTypes ageType, Size size, CarTypes carType) {
		super(toyType, price, ageType, size, carType);
		this.carType = carType;
	}

	private CarTypes carType;

	@Override
	public void play() {
		System.out.println("the car is driving...");
	}

	public CarTypes getCarType() {
		return carType;
	}

	@Override
	public String toString() {
		return super.toString() + " type: " + this.carType;
	}
}
