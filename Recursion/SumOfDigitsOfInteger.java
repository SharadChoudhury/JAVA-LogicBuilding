package Recursion;

public class SumOfDigitsOfInteger {
	
//	private static int sumOfDigits(int input, int sum){
//		if(input==0)
//			return sum;
//		sum =sum + input%10;
//		return sumOfDigits(input/10,sum);
//	}
//	
//	public static int sumOfDigits(int input) {
//		return sumOfDigits(input,0);
//	}
	
	public static int sumOfDigits(int input) {
		if(input<10)
			return input;
		return input%10 + sumOfDigits(input/10);
	}
	
	public static void main(String[] args) {
		System.out.println(sumOfDigits(9));

	}

}
