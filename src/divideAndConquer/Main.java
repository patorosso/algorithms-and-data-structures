package divideAndConquer;

public class Main {

	public static void main(String[] args) {

		int elemToFind = 200;
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 }; // pre-sorted array of positive ints
		BinarySearch binarySearcher = new BinarySearch();

		int result = binarySearcher.doIt(array, elemToFind);

		if (result != -1) {
			System.out.println("Gotcha! " + elemToFind + " was found!" );
		} else
			System.out.println(elemToFind + " was not found!");

	}
}
