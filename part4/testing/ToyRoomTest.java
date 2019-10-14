package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entity.Toy;
import entity.Toy.ChildsAge;
import entity.Toy.Size;
import entity.Toy.ToyTypes;
import service.CompareByOneParameter.Parameter;
import service.Factory;
import service.ToyRoom;

class ToyRoomTest {
	ArrayList<Toy> toys = new ArrayList<Toy>();
	ArrayList<Toy> toysExpected = new ArrayList<Toy>();
	ToyRoom room = new ToyRoom();

	Toy ball40F0to3Big = Factory.createToy(ToyTypes.BALL, 40.0, ChildsAge.from0to3, Size.big);
	Toy doll30F0to3Small = Factory.createToy(ToyTypes.DOLL, 30.2, ChildsAge.from0to3, Size.small);
	Toy cube10F0to3Medium = Factory.createToy(ToyTypes.CUBE, 10.4, ChildsAge.from0to3, Size.medium);
	Toy car120F8to18Big = Factory.createToy(ToyTypes.TOYCAR, 120.0, ChildsAge.from8to18, Size.big);
	Toy doll40F4to7Small = Factory.createToy(ToyTypes.DOLL, 40.0, ChildsAge.from4to7, Size.small);
	Toy ball30F4to7Big = Factory.createToy(ToyTypes.BALL, 30.3, ChildsAge.from4to7, Size.big);

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

		room.createRoom(3, 200.0, ChildsAge.from0to3, toys);
		assertEquals(toysExpected, room.getRoomToys());
		assertTrue(toysExpected.size() == room.getRoomToys().size());
	}

	@Test
	void testSortToys() {
		createToysArray();
		toysExpected.add(doll30F0to3Small);
		toysExpected.add(cube10F0to3Medium);
		toysExpected.add(ball40F0to3Big);

		room.createRoom(3, 200.0, ChildsAge.from0to3, toys);
		room.sortToys(Parameter.SIZE);
		assertTrue(toysExpected.equals(room.getRoomToys()));
	}

	@Test
	void testSortToysByPriceAndSize() {
		createToysArray();
		toysExpected.add(cube10F0to3Medium);
		toysExpected.add(doll30F0to3Small);
		toysExpected.add(ball40F0to3Big);

		room.createRoom(3, 200.0, ChildsAge.from0to3, toys);
		room.sortToysByPriceAndSize();
		assertTrue(toysExpected.equals(room.getRoomToys()));
	}

	@Test
	void testFindToyByPrice() {
		createToysArray();
		Toy toyExpected = cube10F0to3Medium;
		room.createRoom(3, 200.0, ChildsAge.from0to3, toys);
		assertTrue(toyExpected.equals(room.findToyByPrice(10.4)));
	}

	@Test
	void testFindToyByType() {
		createToysArray();
		Toy toyExpected = cube10F0to3Medium;
		room.createRoom(3, 200.0, ChildsAge.from0to3, toys);
		assertTrue(toyExpected.equals(room.findToyByType(ToyTypes.CUBE)));
	}

}
