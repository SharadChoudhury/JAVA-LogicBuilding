package Basics;
import java.util.Scanner;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        int res =1;
        int i=1;
        
        if(n==0||n==1) {
        	System.out.println(n);
        	return;
        }
        
        while(res<=n) {
        	i++;
        	res = i*i;
        }
        System.out.println(i-1);
        
	}

}
