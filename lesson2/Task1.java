package lesson2;

public class Task1 {
	public static void main(String[] args) {

		int x1 = 1;
		int y1 = 1;

		int x2 = 1;
		int y2 = 1;

		int x3 = 1;
		int y3 = -8888888;

		double sideLengthAB = Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
		double sideLengthAC = Math.sqrt((Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2)));
		double sideLengthBC = Math.sqrt((Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2)));

		if (sideLengthAB + sideLengthAC > sideLengthBC && sideLengthAB + sideLengthBC > sideLengthAC
				&& sideLengthAC + sideLengthBC > sideLengthAB) {

			System.out.println(rightTriangleChecker(sideLengthAC, sideLengthAB, sideLengthBC));

		} else {
			System.out.println("It isn't a triangle!");
		}
	}

	private static String rightTriangleChecker(double a, double b, double c) {

		double hypothenuse = 0;
		double leg1 = 0;
		double leg2 = 0;

		if (a > b && a > c) {
			hypothenuse = a;
			leg1 = b;
			leg2 = c;

		} else if (b > c) {
			hypothenuse = b;
			leg1 = a;
			leg2 = c;
		} else if (c > b) {
			hypothenuse = c;
			leg1 = a;
			leg2 = b;
		}

		if (Math.sqrt(hypothenuse) == Math.sqrt(leg2) + Math.sqrt(leg1)) {
			return "It is a right triangle!";
		} else {
			return "It is a triangle.";
		}

	}

}
