package dynamicProgramming;

public class Main {

	public static void main(String[] args) {

//		int number = 9;
//		int result = DynamicProgramming.fibonacci(number);
//
//		System.out.println("Fibonacci number of " + number + " is: " + result);
		
		int[] houses = {1000,9,3,1000,8,1,7};
		int result = DynamicProgramming.houseThief(houses);
		
		System.out.println("House thief could steal: " + result);
	}

}
