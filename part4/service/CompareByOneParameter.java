package service;

import java.util.Comparator;

import entity.Toy;

public class CompareByOneParameter implements Comparator<Toy> {

	public enum Parameter {
		PRICE, SIZE, TYPE, PEGI_AGE
	}

	private Parameter parameter;

	public void setParemeter(Parameter parameter) {
		this.parameter = parameter;
	}

	public CompareByOneParameter(Parameter parameter) {
		super();
		this.parameter = parameter;
	}

	@Override
	public int compare(Toy toy1, Toy toy2) {
		switch (this.parameter) {
		case PRICE:
			return Double.compare(toy1.getPrice(), toy2.getPrice());
		case SIZE:
			return Integer.compare(toy1.getSize().ordinal(), toy2.getSize().ordinal());
		case TYPE:
			return toy1.getType().name().compareTo(toy2.getType().name());
		case PEGI_AGE:
			return Integer.compare(toy1.getChildsage().ordinal(), toy2.getChildsage().ordinal());
		default:
			throw new EnumConstantNotPresentException(this.parameter.getClass(), this.parameter.name());
		}
	}

}
