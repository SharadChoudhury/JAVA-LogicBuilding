package timeComplexity;

public class duplicateInArray {
// for n size, elements in array exist from 0 to n-2.
// so, find sum of n-2
	//time complexity: O(n) , space complexity: O(1)
	public static int findDuplicate(int[] arr) {
		//Your code goes here
        	//Your code goes here
        int sumArr=0;
        int l= arr.length;
        for(int i=0;i < l;i++){
            sumArr = sumArr + arr[i];
        }
        
        int sumOfn = (l-2)*(l-1)/2;
        return sumArr - sumOfn;
        
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1, 0, 2, 3, 1};
		System.out.println(findDuplicate(arr));

	}

}
