package entity;

import enums.AgeTypes;
import enums.CubeTypes;
import enums.Size;
import enums.ToyTypes;
import service.ToyAction;

public class Cube extends Toy implements ToyAction {

	private CubeTypes cubeType;

	public Cube(ToyTypes toyType, double price, AgeTypes ageType, Size size, CubeTypes cubeType) {
		super(toyType, price, ageType, size, cubeType);
		this.cubeType = cubeType;
	}

	@Override
	public void play() {
		System.out.println("the cube is folding...");
	}

	public CubeTypes getCubeType() {
		return cubeType;
	}

	@Override
	public String toString() {
		return super.toString() + " type: " + this.cubeType;
	}
}
