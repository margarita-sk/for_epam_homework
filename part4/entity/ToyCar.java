package entity;

import action.ToyAction;

public class ToyCar extends Toy implements ToyAction {

	@Override
	public void play() {
		System.out.println("машинка едет...");
		
	}

}
