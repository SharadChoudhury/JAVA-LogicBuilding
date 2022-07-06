package timeComplexity_test1;

import java.util.*;

public class budget_max {

	public static int maximumProfit(int budget[]) {
		Arrays.sort(budget);
		int max=-1;
		int arr[] = new int[budget.length];
		for(int i=0;i<budget.length;i++) {
			arr[i]=budget[i]*(budget.length-i);
			if(arr[i]> max)
				max=arr[i];
		}

		return max;
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i=0;i<n;i++)
			input[i] = s.nextInt();
		
		System.out.println(maximumProfit(input));
	}

}
