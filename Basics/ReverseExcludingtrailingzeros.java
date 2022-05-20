package Basics;
import java.util.Scanner;

public class ReverseExcludingtrailingzeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int rem,rev=0;
        
        while(n!=0) {
        	rem = n%10;
        	n=n/10;
        	if(rev==0 && rem==0)  //to exclude trailing zeros
        		continue;
        	rev= rev*10+rem;       	
        }
       System.out.println(rev); 
	}

}
