package entity;

import service.ToyAction;

public class Cube extends Toy implements ToyAction {

	public Cube(double price, ChildsAge childsage, Size size) {
		super(price, childsage, size);
	}

	@Override
	public void play() {
		System.out.println("the cube is folding...");

	}

}
