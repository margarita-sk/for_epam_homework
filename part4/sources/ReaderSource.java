package sources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import entity.Toy;
import enums.AgeTypes;
import enums.Size;
import enums.ToyTypes;
import service.Factory;

public class ReaderSource {

	public static final Logger LOGGER = Logger.getLogger(ReaderSource.class);

	private String line;

	private Pattern typeToy = Pattern.compile("(?<=ToyType:\\s)[A-Z]*");
	private Pattern price = Pattern.compile("(?<=price)*\\d+[\\\\.]*\\d+");
	private Pattern childAge = Pattern.compile("(?<=for children\\s)FROM\\dTO\\d*");
	private Pattern size = Pattern.compile("(?<=size:\\s)[A-Z]*");
	private Pattern specialType = Pattern.compile("(?<=type:\\s)[A-Z]*");

	public ArrayList<Toy> readToysFromFile(File file) {
		ArrayList<Toy> toys = new ArrayList<Toy>();
		BufferedReader buf;

		try {
			FileReader reader = new FileReader(file);
			buf = new BufferedReader(reader);

			while ((line = buf.readLine()) != null) {
				double priceToy = 0;
				AgeTypes ageType = null;
				Size sizeToy = null;
				ToyTypes type = null;
				String obj = null;

				Matcher matchPrice = price.matcher(line);
				Matcher matchAgeType = childAge.matcher(line);
				Matcher matchSize = size.matcher(line);
				Matcher matchType = typeToy.matcher(line);
				Matcher matchObj = specialType.matcher(line);

				try {
					if (matchPrice.find())
						priceToy = Double.parseDouble(matchPrice.group());

					if (matchAgeType.find())
						ageType = AgeTypes.valueOf(matchAgeType.group());

					if (matchSize.find())
						sizeToy = Size.valueOf(matchSize.group());

					if (matchObj.find())
						obj = matchObj.group();

					if (matchType.find())
						type = ToyTypes.valueOf(matchType.group());
				} catch (IllegalArgumentException e) {
					priceToy = 0;
					ageType = null;
					sizeToy = null;
					type = null;
					obj = null;
					LOGGER.warn("The line in file contains an illegal toy's parameter", e);

				}

				if (priceToy > 0 && ageType != null && sizeToy != null && type != null && obj != null) {
					Toy toy = Factory.createToy(type, priceToy, ageType, sizeToy, obj);
					toys.add(toy);
				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.error("File not found", e);
		} catch (IOException e) {
			LOGGER.error("InputOutput exception", e);
		}
		return toys;
	}

}
