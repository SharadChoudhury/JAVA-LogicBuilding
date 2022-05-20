package Basics;
import java.util.Scanner;

public class IncreasingDecreasingSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        boolean isdec;  //false-increasing  true-decreasing
        
        int prev =s.nextInt();
        int current=s.nextInt();
        
        if(current==prev) {
    		System.out.println("false");
    		return;
    	}
    	else if(current>prev){
    		isdec=false;   			
    	}
    	else {
    		isdec=true;
    	}
        
        prev = current;
        for(int i=3;i<=n;i++) {
        	current =s.nextInt();
        	
        	if(current==prev) {
        		System.out.println("false");
        		return;
        	}
        	else if(current>prev){  // increasing
        		isdec=false;       			     		       			
        	}
        	else {  				//decreasing
        		if(isdec==false ) {
        			System.out.println("false");
            		return;
        		}
        	}
        	prev=current;
        }
        
        System.out.println("true");
        
	}

}
