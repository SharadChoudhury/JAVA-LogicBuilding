package Basics;
import java.util.Scanner;

/*  
 Write a program to print parallelogram pattern for the given N number of rows.
For N = 5

*****
.*****
..*****
...*****
....*****

The dots represent spaces.*/
public class parallelogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        for(int i=1;i<=n;i++) {
        	
        	for(int j=1;j<=i-1;j++) {
        		System.out.print(" ");
        	}
        	
        	for(int j=1;j<=n;j++) {
        		System.out.print("*");
        	}
        	
        	System.out.println();
        }
        
	}

}
