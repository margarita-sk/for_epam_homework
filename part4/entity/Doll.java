package entity;

import action.ToyAction;

public class Doll extends Toy implements ToyAction {

	@Override
	public void play() {
		System.out.println("кукла плачет...");
		
	}

}
