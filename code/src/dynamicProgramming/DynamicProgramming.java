package dynamicProgramming;

import java.util.*;

public class DynamicProgramming {

	public static int fibonacci(int n) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int result = fibonacci(map, n);

		return result;
	}

	private static int fibonacci(HashMap<Integer, Integer> map, int n) {

		if (map.containsKey(n))
			return map.get(n);

		if (n < 2) {
			map.put(n, n);
			return n;
		}

		map.put(n, fibonacci(map, n - 1) + fibonacci(map, n - 2));
		return map.get(n);
	}

}
