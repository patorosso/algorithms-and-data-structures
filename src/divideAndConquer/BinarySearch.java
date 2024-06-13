package divideAndConquer;

// simple binary search on integer arrays

public class BinarySearch {

	// what a name
	public int doIt(int[] array, int elemToFind) {

		int left = 0;
		int right = array.length;

		return binarySearch(array, elemToFind, left, right);
	}

	// hidden recursive search
	private int binarySearch(int[] array, int elemToFind, int left, int right) {

		int middle = left + ((right - left) / 2);

		if (right < left || array.length <= middle)
			return -1;

		if (elemToFind == array[middle])
			return 1;

		if (elemToFind < array[middle])
			return binarySearch(array, elemToFind, left, middle - 1);
		else
			return binarySearch(array, elemToFind, middle + 1, right);

	}
}
