package Basics;
import java.util.*;
public class prime2toN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=2;i<=n;i++) {
        	int flag=1;
        	for(int j=2;j<=i/2;j++) {
        		if(i%j==0) {
        			flag=0;
        			break;
        		}       		
        	}
        	
        	if(flag==1)
    			System.out.println(i);
        }
        
        
	}

}
