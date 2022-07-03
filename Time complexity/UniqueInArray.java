package timeComplexity;

public class UniqueInArray {

	//time complexity= O(n)
	public static int findUnique(int[] arr) {
		int res=0;
		for(int i=0;i<arr.length;i++) {
			res=res^arr[i];
		}
        return res;
	}
	
	public static void main(String[] args) {
		int arr[]= {6,2,1,2,1,6,5};
		System.out.println(findUnique(arr));

	}

}
