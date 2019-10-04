package entity;

import action.ToyAction;

public class Ball extends Toy implements ToyAction {

	@Override
	public void play() {
		System.out.println("м�?ч прыгает...");

	}

}
