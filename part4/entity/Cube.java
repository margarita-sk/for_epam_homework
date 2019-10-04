package entity;

import action.ToyAction;

public class Cube extends Toy implements ToyAction {

	@Override
	public void play() {
		System.out.println("кубик �?кладывает�?�?...");

	}

}
