package Arrays;

public class TripletSum {
	
	public static int tripletSum(int arr[], int x) {
//time:O(n^3)
//space:O(1)
    	int n = arr.length;
        int count=0;
        for(int i=0; i<n-2; i++){
            
            for(int j=i+1; j<n-1; j++){
                
                for(int k=j+1; k<n; k++){
                    
                   if(arr[i]+arr[j]+arr[k]==x){
                    	count++;
                	} 
                }
                
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7};
		System.out.println(tripletSum(arr,17));

	}

}
