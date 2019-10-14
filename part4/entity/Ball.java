package entity;

import service.ToyAction;

public class Ball extends Toy implements ToyAction {

	public Ball(ToyTypes type, double price, ChildsAge childsage, Size size) {
		super(type, price, childsage, size);
	}

	@Override
	public void play() {
		System.out.println("the ball is jumping...");

	}

}
