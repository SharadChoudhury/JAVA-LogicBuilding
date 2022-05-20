package Basics;
import java.util.*;
public class sum_even_odd_digits {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int rem, even_sum=0, odd_sum=0;
		
		while(n!=0) {
			rem = n%10;
			if(rem%2==0)
				even_sum = even_sum + rem;
			else
				odd_sum = odd_sum + rem;
			n= n/10;
		}
		
		System.out.println(even_sum+" "+odd_sum);
	}
}
