package entity;

import enums.AgeTypes;
import enums.Size;
import enums.ToyTypes;

public abstract class Toy {

	private ToyTypes toyType;
	private double price;
	private AgeTypes ageType;
	private Size size;

	public Toy(ToyTypes toyType, double price, AgeTypes ageType, Size size, Object obj) {
		super();
		this.toyType = toyType;
		this.price = price;
		this.ageType = ageType;
		this.size = size;
	}

	public ToyTypes getToyType() {
		return toyType;
	}

	public double getPrice() {
		return price;
	}

	public AgeTypes getAgeType() {
		return ageType;
	}

	public Size getSize() {
		return size;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (this.toyType.equals(((Toy) obj).toyType) && this.price == ((Toy) obj).price && this.size == ((Toy) obj).size
				&& this.ageType.equals(((Toy) obj).ageType)) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Toy: " + this.toyType + " size: " + this.size + " price: " + this.price + " for children from "
				+ this.ageType.getMin() + " to " + this.ageType.getMax() + " years old";
	}

}
