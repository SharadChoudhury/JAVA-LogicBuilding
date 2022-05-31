package SearchingSorting;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = {2, 13, 4 ,1 ,9 ,6 ,20};
		int n = arr.length;
        
		// time complexity: O(n^2)
		// Space complexity: O(1)
		
        for(int i=0;i<n;i++){
            int current= arr[i];
            int j=i-1;
//          /* Move elements of arr[0..i-1], that are
//          greater than key, to one position ahead
//          of their current position */
            while(j>=0 && arr[j]>current){
                    arr[j+1]=arr[j];   
                    j--;
            }
            arr[j+1]=current;   
            
        }
       
        
        for(int i:arr)
			System.out.print(i+" ");

	}

}
