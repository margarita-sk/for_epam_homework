package entity;

import enums.AgeTypes;
import enums.DollTypes;
import enums.Size;
import enums.ToyTypes;
import service.ToyAction;

public class Doll extends Toy implements ToyAction {

	private DollTypes dollType;

	public Doll(ToyTypes toyType, double price, AgeTypes ageType, Size size, DollTypes dollType) {
		super(toyType, price, ageType, size, dollType);
		this.dollType = dollType;
	}

	@Override
	public void play() {
		System.out.println("the doll is crying...");

	}

	public DollTypes getDollType() {
		return dollType;
	}

	@Override
	public String toString() {
		return super.toString() + " type: " + this.dollType;
	}

}
