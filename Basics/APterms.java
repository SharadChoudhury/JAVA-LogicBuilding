package Basics;
import java.util.Scanner;

public class APterms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Scanner s = new Scanner(System.in);
       int n = s.nextInt();
        
       int counter = 0;
       int i =1;
       while(counter!=n) {
    	  int res= 3*i+2;
    	  i++;
    	  if(res % 4 != 0) {
    		  System.out.print(res+" ");
    		  counter++;
    	  }
       }
             
      
	}

}
