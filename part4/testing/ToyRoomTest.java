package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entity.Toy;
import enums.AgeTypes;
import enums.Parameter;
import enums.Size;
import enums.ToyTypes;
import service.Factory;
import service.ToyRoom;

class ToyRoomTest {
	ArrayList<Toy> toys = new ArrayList<Toy>();
	ArrayList<Toy> toysExpected = new ArrayList<Toy>();
	ToyRoom room = Factory.createToyRoom(3, 200.0, AgeTypes.FROM0TO3);

	Toy ball40F0to3Big = Factory.createToy(ToyTypes.BALL, 40.0, AgeTypes.FROM0TO3, Size.BIG, "BASKETBALL");
	Toy doll30F0to3Small = Factory.createToy(ToyTypes.DOLL, 30.2, AgeTypes.FROM0TO3, Size.SMALL, "PINOCCHIO");
	Toy cube10F0to3Medium = Factory.createToy(ToyTypes.CUBE, 10.4, AgeTypes.FROM0TO3, Size.MEDIUM, "NUMBERS");
	Toy car120F8to18Big = Factory.createToy(ToyTypes.TOYCAR, 120.0, AgeTypes.FROM8TO18, Size.BIG, "AMBULANCE");
	Toy doll40F4to7Small = Factory.createToy(ToyTypes.DOLL, 40.0, AgeTypes.FROM4TO7, Size.SMALL, "VOODOO");
	Toy ball30F4to7Big = Factory.createToy(ToyTypes.BALL, 30.3, AgeTypes.FROM4TO7, Size.BIG, "TENNIS");

	void createToysArray() {
		toys.add(ball40F0to3Big);
		toys.add(doll30F0to3Small);
		toys.add(cube10F0to3Medium);
		toys.add(car120F8to18Big);
		toys.add(doll40F4to7Small);
		toys.add(ball30F4to7Big);
	}

	@Test
	void testCreateRoom() {
		createToysArray();
		toysExpected.add(ball40F0to3Big);
		toysExpected.add(doll30F0to3Small);
		toysExpected.add(cube10F0to3Medium);

		room.fillRoomWithToys(toys);
		assertEquals(toysExpected, room.getRoomToys());
	}

	@Test
	void testSortToys() {
		createToysArray();
		toysExpected.add(doll30F0to3Small);
		toysExpected.add(cube10F0to3Medium);
		toysExpected.add(ball40F0to3Big);

		room.fillRoomWithToys(toys);
		room.sortToys(Parameter.SIZE);
		assertTrue(toysExpected.equals(room.getRoomToys()));
	}

	@Test
	void testSortToysByPriceAndSize() {
		createToysArray();
		toysExpected.add(cube10F0to3Medium);
		toysExpected.add(doll30F0to3Small);
		toysExpected.add(ball40F0to3Big);

		room.fillRoomWithToys(toys);
		room.sortToysByPriceAndSize();
		assertTrue(toysExpected.equals(room.getRoomToys()));
	}

	@Test
	void testFindToyByPrice() {
		createToysArray();

		toysExpected.add(doll30F0to3Small);
		toysExpected.add(cube10F0to3Medium);

		room.fillRoomWithToys(toys);
		assertTrue(toysExpected.equals(room.findToyByPrice(10.0, 35.0)));
	}

	@Test
	void testFindToyByType() {
		createToysArray();
		toysExpected.add(cube10F0to3Medium);
		room.fillRoomWithToys(toys);
		assertTrue(toysExpected.equals(room.findToyByType(ToyTypes.CUBE)));
	}

}
