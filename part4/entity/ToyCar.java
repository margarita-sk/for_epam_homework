package entity;

import service.ToyAction;

public class ToyCar extends Toy implements ToyAction {

	public ToyCar(ToyTypes type, double price, ChildsAge childsage, Size size) {
		super(type, price, childsage, size);
	}

	@Override
	public void play() {
		System.out.println("the car is driving...");
	}

}
