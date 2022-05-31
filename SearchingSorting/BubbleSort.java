package SearchingSorting;

public class BubbleSort {
	
//this code places the smallest integer in the ith posn of arr in every iteration of i
  	
	public static void bubblesort1(int[] arr) {
		// time complexity: O(n^2)
		// Space complexity: O(1)
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]>arr[j]) {
					int temp= arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
	}

//this code places the largest integer in the (n-i)th posn of arr in every iteration
//of i
	
	public static void bubblesort2(int[] arr) {
		// time complexity: O(n^2)
		// Space complexity: O(1)
		int n = arr.length;
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-i-1;j++) {  //n-i-1 because in very iteration of i, largest 
										// element is placed at the (n-1-i)th position
				if(arr[j]>arr[j+1]) {
					int temp= arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr= {2, 13, 4, 10, 3, 6, 28};
		bubblesort2(arr);		
		for(int i:arr)
			System.out.print(i+" ");

		}


}
