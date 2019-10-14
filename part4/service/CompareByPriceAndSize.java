package service;

import java.util.Comparator;

import entity.Toy;

public class CompareByPriceAndSize implements Comparator<Toy> {

	@Override
	public int compare(Toy toy1, Toy toy2) {
		if (Double.compare(toy1.getPrice(), toy2.getPrice()) == 0) {
			return toy1.getSize().name().compareTo(toy2.getSize().name());
		} else {
			return Double.compare(toy1.getPrice(), toy2.getPrice());
		}
	}

}
