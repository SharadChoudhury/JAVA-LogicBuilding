package SearchingSorting;

public class SelectionSort {
	public static void selectionsort(int[] arr) {
		int n= arr.length;
		
//time complexity: O(n^2)
//space complexity: O(1)
		
		for(int i=0;i<n-1;i++) {
// at each iteration, the the minimum element in range i+1 to n-1 is placed at 
// the ith index
			int min = arr[i];
			int index=i;
			
			for(int j=i+1;j<n;j++) {
				if(arr[j]<min) {
					min= arr[j];
					index=j;
				}
			}
			
			if(index!=i) { //swap ith element with index element if min found in 
		//range i+1 to n-1
				arr[index]=arr[i];
				arr[i]=min;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr= {2, 13, 4, 1, 3, 6, 28};
		selectionsort(arr);
		for(int i:arr)
			System.out.print(i+" ");

	}

}
