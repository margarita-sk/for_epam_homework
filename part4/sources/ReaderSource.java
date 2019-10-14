package sources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Toy;
import entity.Toy.ChildsAge;
import entity.Toy.Size;
import entity.Toy.ToyTypes;
import service.Factory;

public class ReaderSource {

	private String line;

	private Pattern doll = Pattern.compile("[Dd]oll");
	private Pattern car = Pattern.compile("[Cc]ar");
	private Pattern cube = Pattern.compile("[Cc]ube");
	private Pattern ball = Pattern.compile("[Bb]all");

	private Pattern price = Pattern.compile("(?<=price)*\\d+[\\\\.]*\\d+");
	private Pattern childsage = Pattern.compile("(?<=for children\\s)from\\dto\\d*");
	private Pattern size = Pattern.compile("(?<=size:\\s)[a-z]*");

	public ArrayList<Toy> readToysFromFile(File file) {
		ArrayList<Toy> toys = new ArrayList<Toy>();
		BufferedReader buf;

		try {
			FileReader reader = new FileReader(file);
			buf = new BufferedReader(reader);

			while ((line = buf.readLine()) != null) {
				double priceToy = 0;
				ChildsAge age = null;
				Size sizeToy = null;
				ToyTypes type = null;

				Matcher matchPrice = price.matcher(line); // ищем цену
				if (matchPrice.find()) {
					priceToy = Double.parseDouble(matchPrice.group());
				}

				Matcher matchAge;
				Matcher matchSize;
				matchAge = childsage.matcher(line);
				matchSize = size.matcher(line);
				try {
					if (matchAge.find()) {
						age = ChildsAge.valueOf(matchAge.group());
					}
					if (matchSize.find()) {
						sizeToy = Size.valueOf(matchSize.group());
					}
				} catch (IllegalArgumentException e) {
					age = null;
					sizeToy = null;
				}

				Matcher matcherDoll = doll.matcher(line);
				if (matcherDoll.find())
					type = ToyTypes.DOLL;

				Matcher matcherCar = car.matcher(line);
				if (matcherCar.find())
					type = ToyTypes.TOYCAR;

				Matcher matcherCube = cube.matcher(line);
				if (matcherCube.find())
					type = ToyTypes.CUBE;

				Matcher matcherBall = ball.matcher(line);
				if (matcherBall.find())
					type = ToyTypes.BALL;

				if (priceToy != 0 && age != null && sizeToy != null && type != null) {
					Toy toy = Factory.createToy(type, priceToy, age, sizeToy);
					toys.add(toy);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return toys;

	}

}
