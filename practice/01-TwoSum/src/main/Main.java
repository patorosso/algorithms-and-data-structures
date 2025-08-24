package main;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		try {
			int target = 22;
			int[] nums = { 22, 2, 7, 11, 15 };

			boolean result = hasTwoSum(nums, target);
			System.out.println("Resultado final: " + result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static boolean hasTwoSum(int[] nums, int target) {
		if (nums.length < 2)
			throw new IllegalArgumentException("La entrada debe contener dos elementos mínimamente.");

//		return hasTwoSumBrute(nums, target);
		return hasTwoSumWindow(nums, target);
//		return hasTwoSumLinear(nums, target);
	}

	// O(n*(n-1)/2) -> O(n^2)
	private static boolean hasTwoSumBrute(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				long sum = nums[i] + nums[j];
				System.out.println("Probando los números: " + nums[i] + " + " + nums[j] + " = " + sum);
				if (sum == target)
					return true;
			}
			System.out.println("No se encontró, se realiza otra pasada\n");
		}
		return false;
	}

	private static boolean hasTwoSumWindow(int[] nums, int target) {
		int[] sortedNumsCopy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sortedNumsCopy);

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			long sum = sortedNumsCopy[start] + sortedNumsCopy[end];

			if (sum == target)
				return true;

			if (sum > target)
				end--;
			else
				start++;
		}

		return false;
	}

	// O(n)
	private static boolean hasTwoSumLinear(int[] nums, int target) {
		HashSet<Integer> remainders = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (remainders.contains(nums[i]))
				return true;
			else
				remainders.add(target - nums[i]);
		}
		return false;
	}
}
