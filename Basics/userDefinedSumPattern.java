package Basics;
import java.util.Scanner;

public class userDefinedSumPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        for(int i=1;i<=n;i++) {
        	int sum=0;
        	int j;
        	for(j=1;j<i;j++) {
        		sum=sum+j;
        		System.out.print(j+"+");
        	}
        	sum=sum+j;
        	System.out.println(j+"="+sum);
        }
	}

}
