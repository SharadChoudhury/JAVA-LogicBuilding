package Recursion;
import java.util.Scanner;

public class powerOfn {
	//time : O(n)       space : O(n)
	public static int power(int x, int n) {
        if(n==0)
            return 1;
        int product = x * power(x,n-1);
        return product;
		
	}
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int x = s.nextInt();
		int n = s.nextInt();
		
		System.out.println(power(x, n));
	}
	
}
