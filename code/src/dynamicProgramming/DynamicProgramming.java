package dynamicProgramming;

import java.util.*;

public class DynamicProgramming {

	public static int fibonacci(int n) {

		// int result = fibonacciTopDown(new HashMap<Integer, Integer>(), n);
		int result = fibonacciBottomDown(new int[n + 1], n);

		return result;
	}

	private static int fibonacciTopDown(HashMap<Integer, Integer> map, int n) {

		if (map.containsKey(n))
			return map.get(n);

		if (n < 2) {
			map.put(n, n);
			return n;
		}

		map.put(n, fibonacciTopDown(map, n - 1) + fibonacciTopDown(map, n - 2));
		return map.get(n);
	}

	private static int fibonacciBottomDown(int[] array, int n) {

		if (n < 2)
			return n;

		// array[0] = 0; not needed
		array[1] = 1;

		// we could do this, but as fibonacci only needs the 2 previous values of n,
		// there's no need to keep in the table all previous values.
		// we could just use aux variables to store those values.
		for (int i = 2; i <= n; i++)
			array[i] = array[i - 1] + array[i - 2];

		return array[n];
	}

	// bottom down approach
	public static int houseThief(int[] houses) {

		int length = houses.length;

		if (length == 0)
			return 0;

		if (length == 1)
			return houses[0];

		if (length == 2)
			return Integer.max(houses[0], houses[1]);

		// initialize loot array
		int[] loot = new int[length];
		loot[0] = houses[0];
		loot[1] = Math.max(houses[0], houses[1]);

		// fill remaining positions
		for (int i = 2; i < length; i++)
			loot[i] = Math.max(houses[i] + loot[i - 2], loot[i - 1]);

		return loot[length - 1];
	}

}
