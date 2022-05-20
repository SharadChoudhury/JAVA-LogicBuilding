package Basics;
import java.util.Scanner;

/* for n=5 : 
			 	13579
				35791
				57913
				79135
				91357
	
	n=4:
				1357
				3571
				5713
				7135
 */
public class OddSquarePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        for(int i=1;i<=n;i++) {
        	int t=2*i-1;
        	for(int j=1;j<=n;j++) {
        		System.out.print(t);
        		if(t==2*n-1)
        			t=1;
        		else
        			t+=2;
        	}
        	System.out.println();
        }
        
	}

}
