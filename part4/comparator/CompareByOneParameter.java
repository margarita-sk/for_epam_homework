package comparator;

import java.util.Comparator;

import org.apache.log4j.Logger;

import controller.Menu;
import entity.Toy;
import enums.Parameter;

public class CompareByOneParameter implements Comparator<Toy> {

	private static final Logger LOGGER = Logger.getLogger(Menu.class);

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
			return toy1.getToyType().compareTo(toy2.getToyType());
		default:
			EnumConstantNotPresentException exception = new EnumConstantNotPresentException(this.parameter.getClass(),
					this.parameter.name());
			LOGGER.error("Wrong parameter to compare", exception);
			throw exception;
		}
	}

}
