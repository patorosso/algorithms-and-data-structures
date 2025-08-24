package main;

public class Main {

	public static void main(String[] args) {
		try {
			int n = 8;
			int result = streetNumbers(n);

			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static int streetNumbers(int n) {
		if (n <= 2)
			throw new IllegalArgumentException("La entrada debe ser mayor a 2.");

		return streetNumbersQuadratic(n);
//		return streetNumbersLinear(n);
//		return streetNumbersConstant(n);
	}

	private static int streetNumbersQuadratic(int n) {
		
//		for(int i = )
		
		return -1;
	}

	private static int streetNumbersLinear(int n) {
		return -1;
	}

	private static int streetNumbersConstant(int n) {
		return -1;
	}

}
