package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entity.Toy;
import entity.Toy.ChildsAge;
import entity.Toy.Size;
import entity.Toy.ToyTypes;
import service.Factory;
import sources.ReaderSource;

class ReaderSourceTest {
	File file = new File("D:\\workspace\\HomeworkPart4\\text_small.txt");
	File wrongFile = new File("D:\\workspace\\HomeworkPart4\\wrong_small.txt");
	ArrayList<Toy> expectedToys = new ArrayList<Toy>();

	@Test
	void testReadToysFromCorrectFile() {
		ReaderSource reader = new ReaderSource();
		ArrayList<Toy> toys = reader.readToysFromFile(file);

		expectedToys.add(Factory.createToy(ToyTypes.DOLL, 120.3, ChildsAge.from0to3, Size.small));
		expectedToys.add(Factory.createToy(ToyTypes.BALL, 12.0, ChildsAge.from4to7, Size.big));
		assertTrue(toys.equals(expectedToys));
	}

	@Test
	void testReadToysFromWrongFile() {
		ReaderSource reader = new ReaderSource();
		ArrayList<Toy> toys = reader.readToysFromFile(wrongFile);

		expectedToys.add(Factory.createToy(ToyTypes.TOYCAR, 300.0, ChildsAge.from0to3, Size.big));
		assertTrue(toys.equals(expectedToys));
	}

}
