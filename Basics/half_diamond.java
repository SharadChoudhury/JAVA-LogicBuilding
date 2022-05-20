package Basics;
/*
  print this 	
  n=3
		*
		*1*
		*121*
		*12321*
		*121*
		*1*
		*
  n=5
		*
		*1*
		*121*
		*12321*
		*1234321*
		*123454321*
		*1234321*
		*12321*
		*121*
		*1*
		*
*/

import java.util.*;
public class half_diamond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        //line 1
        System.out.println("*");
        
        //line 2 - n+1
        for(int i=1;i<=2*n-1;i++) {
        	
        	System.out.print("*");
        	int t=1;
        	
        	if(i<=n) {
        		for(int j =1;j<=2*i-1;j++) {
            		if(j<i) {
            			System.out.print(t);
                		t++;
            		}
            		else {
            			System.out.print(t);
                		t--;
            		}
            	} 
        	}
        	
        	else {
        		for(int j =1;j<=2*(2*n-i)-1;j++) {
            		if(j<2*n-i) {
            			System.out.print(t);
                		t++;
            		}
            		else {
            			System.out.print(t);
                		t--;
            		}
            	} 
        	}
        	        
        	System.out.println("*");
        }
        
        //line 2*n + 1
        System.out.println("*");
                
	}

}
