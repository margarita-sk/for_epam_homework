package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entity.Toy;
import enums.AgeTypes;
import enums.Size;
import enums.ToyTypes;
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

		expectedToys.add(Factory.createToy(ToyTypes.DOLL, 120.3, AgeTypes.FROM0TO3, Size.SMALL, "BARBIE"));
		expectedToys.add(Factory.createToy(ToyTypes.BALL, 12.0, AgeTypes.FROM4TO7, Size.BIG, "FOOTBALL"));
		assertTrue(toys.equals(expectedToys));
	}

	@Test
	void testReadToysFromWrongFile() throws IllegalArgumentException {
		ReaderSource reader = new ReaderSource();
		ArrayList<Toy> toys = reader.readToysFromFile(wrongFile);
		assertTrue(toys.size() == 0);
	}
}
