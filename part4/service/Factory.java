package service;

import entity.Ball;
import entity.Cube;
import entity.Doll;
import entity.Toy;
import entity.Toy.ChildsAge;
import entity.Toy.Size;
import entity.ToyCar;

public class Factory {

	public static Toy createToy(Toy.ToyTypes type, double price, ChildsAge childsage, Size size) {

		switch (type) {
		case BALL:
			return new Ball(type, price, childsage, size);
		case CUBE:
			return new Cube(type, price, childsage, size);
		case DOLL:
			return new Doll(type, price, childsage, size);
		case TOYCAR:
			return new ToyCar(type, price, childsage, size);
		default:
			System.out.println("You can't create such type of toy...");
			return null;
		}
	}

}
