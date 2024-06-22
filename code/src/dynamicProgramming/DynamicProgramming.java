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

	public static int goldMine(int[][] mine) {

		int maxObtainedGold = 0;
		HashMap<Position, Integer> map = new HashMap<Position, Integer>();

		for (int i = 0; i < mine[0].length; i++) {
			Position position = new Position(0, i);
			int obtainedGold = goldMine(mine, map, position);

			if (obtainedGold > maxObtainedGold)
				maxObtainedGold = obtainedGold;
		}

		return maxObtainedGold;
	}

	// top-down implementation
	private static int goldMine(int[][] mine, HashMap<Position, Integer> map, Position position) {

		if (map.containsKey(position))
			return map.get(position);

		int row = position.getRow();
		int column = position.getColumn();

		if (row == mine.length - 1) {
			map.put(position, mine[row][column]);
			return mine[row][column];
		}

		if (column == 0) {
			Position south = new Position(row + 1, column);
			Position southEast = new Position(row + 1, column + 1); // i should consider if the mine has only 1 col...

			map.put(position,
					mine[row][column] + Integer.max(goldMine(mine, map, south), goldMine(mine, map, southEast)));
			return map.get(position);
		}

		if (column == mine[0].length - 1) {
			Position south = new Position(row + 1, column);
			Position southWest = new Position(row + 1, column - 1); // i should consider if the mine has only 1 col...

			map.put(position,
					mine[row][column] + Integer.max(goldMine(mine, map, south), goldMine(mine, map, southWest)));
			return map.get(position);
		}

		Position south = new Position(row + 1, column);
		Position southWest = new Position(row + 1, column - 1); // i should consider if the mine has only 1 col...
		Position southEast = new Position(row + 1, column + 1); // i should consider if the mine has only 1 col...

		int maxSouth = goldMine(mine, map, south);
		int maxSouthWest = goldMine(mine, map, southWest);
		int maxSouthEast = goldMine(mine, map, southEast);
		int max = Integer.max(maxSouth, Integer.max(maxSouthWest, maxSouthEast));

		map.put(position, mine[row][column] + max);
		return map.get(position);
	}

}
