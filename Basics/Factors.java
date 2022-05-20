package Basics;
import java.util.*;
public class Factors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		
		for(int i=2;i<=n/2;i++) {
			if(n%i==0) {
				System.out.print(i+" ");
			}
		}
	}

}
