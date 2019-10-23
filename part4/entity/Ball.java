package entity;

import enums.AgeTypes;
import enums.BallTypes;
import enums.Size;
import enums.ToyTypes;
import service.ToyAction;

public class Ball extends Toy implements ToyAction {

	public Ball(ToyTypes toyType, double price, AgeTypes ageType, Size size, BallTypes ballType) {
		super(toyType, price, ageType, size, ballType);
		this.ballType = ballType;
	}

	private BallTypes ballType;

	@Override
	public void play() {
		System.out.println("the ball is jumping...");

	}

	public BallTypes getBallType() {
		return ballType;
	}

	@Override
	public String toString() {
		return super.toString() + " type: " + this.ballType;
	}
}
