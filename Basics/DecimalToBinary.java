package Basics;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int rem,i=0;
        long bin=0;
        
        while(n!=0) {
        	rem = n%2;
        	n=n/2;
        	bin = bin + (long)(rem*Math.pow(10,i));
        	i++;
        
        }
       System.out.println(bin); 

	}

}
