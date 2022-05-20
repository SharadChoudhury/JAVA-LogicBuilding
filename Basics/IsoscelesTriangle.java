package Basics;
import java.util.*;
public class IsoscelesTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i =1 ; i<=(n-1)/2; i++){
            int j =1;
            while(j<=n/2 -i+1){
                System.out.print(" ");
                j++;
            }

            j = 1;
            while(j<=2*i-1){
                System.out.print("*");
                j++;
            }
            
            System.out.println(); 
        }
            
        for(int i =1;i<=n;i++){
          System.out.print("*");  
        }
        
        System.out.println();
        
        for(int i=(n-1)/2;i>=1;i--){
           int j =1;
           while(j<=n/2-i+1){
                System.out.print(" ");
                j++;
            } 
            j = 1;
            while(j<=2*i-1){
                System.out.print("*");
                j++;
            }
           System.out.println();  
        }
        
	}

}
