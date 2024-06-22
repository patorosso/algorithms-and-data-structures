package dynamicProgramming;

public class Main {

	public static void main(String[] args) {

//		int number = 9;
//		int result = DynamicProgramming.fibonacci(number);
//
//		System.out.println("Fibonacci number of " + number + " is: " + result);

//		int[] houses = {1000,9,3,1000,8,1,7};
//		int result = DynamicProgramming.houseThief(houses);
//		
//		System.out.println("House thief could steal: " + result);

		int runs = 1000;
		long totalTime = 0;
		int[][] goldMine = { { 3, 2, 12, 15, 10 }, { 6, 19, 7, 11, 17 }, { 8, 5, 12, 32, 21 }, { 3, 20, 2, 9, 7 } };

		for (int i = 0; i < runs; i++) {

			long startTime = System.nanoTime();
			DynamicProgramming.goldMine(goldMine);
			long endTime = System.nanoTime();

			totalTime += (endTime - startTime);
		}

		double averageTime = totalTime / (double) runs;
		System.out.println("Average execution time over " + runs + " runs: " + averageTime + " nanoseconds");

	}

}
