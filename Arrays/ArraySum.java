package Arrays;
import java.util.*;
public class ArraySum {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		//time complexity= O(n)
		//space complexity= O(1)
		
		int sumarr[]= new int[t];
		
		for(int i=0;i<t;i++) {
			
			int size = s.nextInt();
			int[] arr= new int[size];
			
			int sum =0;
			for(int j=0;j<size;j++) {
				arr[j]=s.nextInt();
				sum=sum+arr[j];
			}
			sumarr[i]=sum;			
		}
		
		for(int i=0;i<t;i++) {
			System.out.println(sumarr[i]);
		}
				
	}

}
