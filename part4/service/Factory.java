package service;

import org.apache.log4j.Logger;

import entity.Ball;
import entity.Cube;
import entity.Doll;
import entity.Toy;
import enums.Size;
import enums.AgeTypes;
import enums.BallTypes;
import enums.CarTypes;
import enums.CubeTypes;
import enums.DollTypes;
import enums.ToyTypes;
import entity.ToyCar;

public class Factory {

	public static final Logger logger = Logger.getLogger(Factory.class);

	public static Toy createToy(ToyTypes type, double price, AgeTypes ageType, Size size, String obj) {

		switch (type) {
		case BALL:
			return new Ball(type, price, ageType, size, BallTypes.valueOf(obj));
		case CUBE:
			return new Cube(type, price, ageType, size, CubeTypes.valueOf(obj));
		case DOLL:
			return new Doll(type, price, ageType, size, DollTypes.valueOf(obj));
		case TOYCAR:
			return new ToyCar(type, price, ageType, size, CarTypes.valueOf(obj));
		default:
			return null;
		}
	}

	public static ToyRoom createToyRoom(int maxNumberOfToys, double maxCostToysInRoom, AgeTypes ageType) {
		ToyRoom room = new ToyRoom();
		room.setMaxNumberOfToys(maxNumberOfToys);
		room.setMaxCostToysInRoom(maxCostToysInRoom);
		room.setAgeType(ageType);
		logger.info("room parameters: max number of toys - " + maxNumberOfToys);
		logger.info(" max cost of toys that can be added to this room " + maxCostToysInRoom);
		logger.info(" age type of rooom - " + ageType);
		return room;
	}

}
