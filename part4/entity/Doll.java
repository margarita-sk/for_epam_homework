package entity;

import service.ToyAction;

public class Doll extends Toy implements ToyAction {

	public Doll(ToyTypes type, double price, ChildsAge childsage, Size size) {
		super(type, price, childsage, size);
	}

	@Override
	public void play() {
		System.out.println("the doll is crying...");

	}

}
