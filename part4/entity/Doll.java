package entity;

import service.ToyAction;

public class Doll extends Toy implements ToyAction {

	public Doll(double price, ChildsAge childsage, Size size) {
		super(price, childsage, size);
	}

	public Doll() {
	}

	@Override
	public void play() {
		System.out.println("the doll is crying...");

	}

}
