package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entity.Ball;
import entity.Cube;
import entity.Doll;
import entity.Toy;
import entity.Toy.ChildsAge;
import entity.Toy.Size;
import entity.ToyCar;
import service.ToyRoom;

class ToyRoomTest {

	private static final int roomCapacity = 3;
	private static final double totalCoast = 140;
	private static final String childAge = "from0to3";

	ArrayList<Toy> toys = new ArrayList<Toy>();
	ArrayList<Toy> toysExpected = new ArrayList<Toy>();

	static Toy toy1 = new Ball(15.0, ChildsAge.from0to3, Size.small);
	static Toy toy2 = new ToyCar(20.0, ChildsAge.from4to7, Size.medium);
	static Toy toy3 = new Doll(18.4, ChildsAge.from8to18, Size.big);
	static Toy toy4 = new Cube(30.0, ChildsAge.from4to7, Size.small);
	static Toy toy5 = new Ball(20.3, ChildsAge.from4to7, Size.big);
	static Toy toy6 = new ToyCar(32.2, ChildsAge.from0to3, Size.medium);
	static Toy toy7 = new Ball(15.8, ChildsAge.from4to7, Size.big);
	static Toy toy8 = new Ball(10.8, ChildsAge.from0to3, Size.small);

	@Test
	void testCreateRoom() {
		toys.add(toy1);
		toys.add(toy2);
		toys.add(toy3);
		toys.add(toy4);
		toys.add(toy5);
		toys.add(toy6);
		toys.add(toy7);
		toys.add(toy8);

		toysExpected.add(toy1);
		toysExpected.add(toy6);
		toysExpected.add(toy8);

		ToyRoom room = new ToyRoom();
		room.createRoom(roomCapacity, totalCoast, childAge, toys);

		assertEquals(toysExpected, room.getRoomToys());
		assertTrue(toysExpected.size() == room.getRoomToys().size());

	}

	@Test
	void testFindCurrentToyDoubleString() {
		toysExpected.add(toy1);
		toysExpected.add(toy6);
		toysExpected.add(toy8);

		ToyRoom room = new ToyRoom();
		room.createRoom(roomCapacity, totalCoast, childAge, toysExpected);

		assertTrue(toy8.equals(room.findCurrentToy(10.8, "small")));
	}

	@Test
	void testFindCurrentToyString() {
		toysExpected.add(toy1);
		toysExpected.add(toy6);
		toysExpected.add(toy8);

		ToyRoom room = new ToyRoom();
		room.createRoom(roomCapacity, totalCoast, childAge, toysExpected);
		assertTrue(toy1.getClass().getSimpleName().equals(room.findCurrentToy("Ball").getClass().getSimpleName()));
	}

	@Test
	void testSortToysByPrice() {
		toys.add(new Ball(10, ChildsAge.from0to3, Size.big));
		toys.add(new Doll(42, ChildsAge.from0to3, Size.small));
		toys.add(new Cube(30.4, ChildsAge.from0to3, Size.medium));

		toysExpected.add(new Doll(42, ChildsAge.from0to3, Size.small));
		toysExpected.add(new Cube(30.4, ChildsAge.from0to3, Size.medium));
		toysExpected.add(new Ball(10, ChildsAge.from0to3, Size.big));

		ToyRoom room = new ToyRoom();
		room.createRoom(roomCapacity, totalCoast, childAge, toysExpected);
		room.sortToysByPrice(-1); // 1 по возрастанию, -1 по убыванию

		for (int i = 0; i < room.getRoomToys().size(); i++) {
			assertTrue(room.getRoomToys().get(i).getPrice() == toysExpected.get(i).getPrice());
		}
	}

	@Test
	void testSortToysBySize() {
		toys.add(toy3);
		toys.add(toy2);
		toys.add(toy1);

		toysExpected.add(toy1);
		toysExpected.add(toy2);
		toysExpected.add(toy3);

		ToyRoom room = new ToyRoom();
		room.createRoom(roomCapacity, totalCoast, childAge, toysExpected);
		room.sortToysBySize(1); // 1 по возрастанию, -1 по убыванию

		for (int i = 0; i < room.getRoomToys().size(); i++) {
			assertTrue(room.getRoomToys().get(i).getSize().equals(toysExpected.get(i).getSize()));
		}
	}

	@Test
	void testSortToysBySizeAndPrice() {

	}

	@Test
	void testGetRoomToys() {
		toysExpected.add(toy1);
		toysExpected.add(toy6);
		toysExpected.add(toy8);

		ToyRoom room = new ToyRoom();
		room.createRoom(roomCapacity, totalCoast, childAge, toysExpected);
		assertEquals(toysExpected, room.getRoomToys());
	}
}
