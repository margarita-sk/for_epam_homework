package part3;

public class Main {

	public static void main(String[] args) {

		Actions actions = new Actions();
		Arrays array = new Arrays();

		double[][] randomArray = actions.fillArray(array.createEmptyRandomArray());

		array.printArray(randomArray);

		actions.findMaxNumber(randomArray);
		actions.findLocalMin(randomArray);
		actions.findMeanArithmetical(randomArray);
		actions.findMeanGeometrical(randomArray);

		System.out.println("Local min:  " + actions.findLocalMax(randomArray));
		System.out.println("Local max:  " + actions.findLocalMin(randomArray));

		array.printArray(actions.transposeMatrix(randomArray));

	}

}
