package Basics;
import java.util.*;
import java.lang.Math;
public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int rem,dec=0,i=0;
        
        while(n!=0) {
        	rem = n%10;
        	n=n/10;
            
        	if(rem==0){
        	    i++;
        	    continue;
        	}
        	
        	dec = dec + (int)(rem*Math.pow(2,i));
        	i++;
        
        }
       System.out.println(dec); 

	}

}
