package sorting;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] array = { 4, 5, 7, 1, 2, 6, 8, 9, 10, 3, 11, 0 };
		int[] sortedArray = Sort.insertion(array);

		System.out.println("Original: " + Arrays.toString(array));
		System.out.println("Sorted:   " + Arrays.toString(sortedArray));

	}

}
