package timeComplexity;

public class RotateArray {
	
	public static void rotate(int[] arr, int d) {
    	//Your code goes here
        if(d==0 || d==arr.length)
            return;
        int[] temp=new int[d];
        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }
        
        for(int i=d;i<arr.length;i++){
            arr[i-d]=arr[i];
        }
        
        for(int i=0;i<d;i++){
            arr[arr.length-d+i]=temp[i];
        }
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,6,7,3,8};
		rotate(arr,3);
		for(int i:arr)
			System.out.print(i+" ");
	}

}
