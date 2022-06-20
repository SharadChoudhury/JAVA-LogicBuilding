package Recursion;
import java.util.*;

public class CountDigits {
	static int cnt=0;
	    
		public static int count(int n){

	    //method 1		time= O(logn) [base 10],  space:O(logn) [base 10]
			// if(n==0){
			// return cnt;
			// }  
			// cnt+=1;
			// count(n/10);
			// return cnt;
	 
	    //method 2		time= O(logn) [base 10],  space:O(logn) [base 10]
	        // if(n<10)
	        //     return 1;
	        // else
	        //     return 1+ count(n/10);
	        
	    //method 3 :	 time= O(logn) [base 10],  space:O(logn) [base 10]
	        if(n==0)
	            return 0;
	        int ans=count(n/10);
	        return ans+1;
		}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(count(n));

	}

}
