package Recursion;

import java.text.DecimalFormat;

public class geometricSum {
	
//	private static double findGeometricSum(int k,double sum){
//		if(k==0)
//			return sum+1;
//		sum = sum + 1/Math.pow(2, k);
//		return findGeometricSum(k-1,sum);
//	}
//	
//	public static double findGeometricSum(int k) {
//		return findGeometricSum(k,0);
//	}
	
	public static double findGeometricSum(int k){
	//time: O(n)
	//space: O(n)
		if(k==0)
			return 1;
	
		return  1/Math.pow(2,k) + findGeometricSum(k-1) ;
	}
			
	public static void main(String[] args) {
		double ans = findGeometricSum(4);
		DecimalFormat dec = new DecimalFormat("#0.00000");
		System.out.println(dec.format(ans));
	}

}

