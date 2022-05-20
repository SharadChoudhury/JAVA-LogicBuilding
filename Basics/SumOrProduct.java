package Basics;
import java.util.Scanner;

public class SumOrProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = s.nextInt();
        
        switch(c){
        case 1:
        	int sum =0;
        	for(int i=1;i<=n;i++) {
        		sum = sum+i;
        	}
        	System.out.println(sum);
        	break;
        
        case 2:
        	int mul =1;
        	for(int i=1;i<=n;i++) {
        		mul = mul*i;
        	}
        	System.out.println(mul);
        	break;
        	
        default:
        	System.out.println("-1");
        }
        
	}

}
