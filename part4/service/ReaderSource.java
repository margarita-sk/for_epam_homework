package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Ball;
import entity.Cube;
import entity.Doll;
import entity.Toy;
import entity.ToyCar;
import entity.Toy.ChildsAge;
import entity.Toy.Size;

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
				String age = null;
				String sizeToy = null;
				Toy toy = null;

				Matcher matchPrice = price.matcher(line); // ищем цену
				if (matchPrice.find()) {
					priceToy = Double.parseDouble(matchPrice.group());
				}

				Matcher matchAge = childsage.matcher(line);// ищем возрастной ценз
				if (matchAge.find()) {
					age = matchAge.group();
				}

				Matcher matchSize = size.matcher(line);// ищем размер
				if (matchSize.find()) {
					sizeToy = matchSize.group();
				}

				if (priceToy != 0 & matchAge != null & matchSize != null) {
					Matcher matcherDoll = doll.matcher(line);
					if (matcherDoll.find()) {
						toy = new Doll(priceToy, ChildsAge.valueOf(age), Size.valueOf(sizeToy));
					}

					Matcher matcherCar = car.matcher(line);
					if (matcherCar.find()) {
						toy = new ToyCar(priceToy, ChildsAge.valueOf(age), Size.valueOf(sizeToy));
					}

					Matcher matcherBall = ball.matcher(line);
					if (matcherBall.find()) {
						toy = new Ball(priceToy, ChildsAge.valueOf(age), Size.valueOf(sizeToy));
					}

					Matcher matcherCube = cube.matcher(line);
					if (matcherCube.find()) {
						toy = new Cube(priceToy, ChildsAge.valueOf(age), Size.valueOf(sizeToy));
					}
				}

				if (toy != null)
					toys.add(toy);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return toys;

	}

}
