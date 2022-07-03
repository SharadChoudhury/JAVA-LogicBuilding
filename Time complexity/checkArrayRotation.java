package timeComplexity;

public class checkArrayRotation {

	 public static int arrayRotateCheck(int[] arr){
	    	int i=0;
	        int count=1;
	        
	        while(i< arr.length-1 && arr[i]<=arr[i+1]){
	            count++;
	            i++;
	        }
	        if(count==arr.length || arr.length==0)//empty array  case is important
	            return 0;
	        else
	            return count;
	 }
	
	public static void main(String[] args) {
		int[] arr= {};
		System.out.println(arrayRotateCheck(arr));

	}

}
