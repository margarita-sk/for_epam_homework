package entity;

import service.ToyAction;

public class Cube extends Toy implements ToyAction {

	public Cube(ToyTypes type, double price, ChildsAge childsage, Size size) {
		super(type, price, childsage, size);
	}

	@Override
	public void play() {
		System.out.println("the cube is folding...");
	}

}
