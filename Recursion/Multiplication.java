package Recursion;
import java.util.*;
public class Multiplication {
	
	public static int multiply(int m, int n){
	//time: O(n)
	//space: O(n)
		if(m==0 || n==0)
			return 0;
		
		return m + multiply(m,n-1);	
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		System.out.println(multiply(m, n));
	}
}
