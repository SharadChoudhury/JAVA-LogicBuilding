package Basics;
import java.util.*;
public class nthFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a=1, b=1;
		int sum = 0;
		
		for(int i=3;i<=n;i++) {
			sum = a+b;
			a=b;
			b=sum;
		}
		System.out.println(b);
	}

}
