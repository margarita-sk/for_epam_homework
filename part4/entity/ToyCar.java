package entity;

import service.ToyAction;

public class ToyCar extends Toy implements ToyAction {

	public ToyCar(double price, ChildsAge childsage, Size size) {
		super(price, childsage, size);
	}

	@Override
	public void play() {
		System.out.println("the car is driving...");

	}

}
