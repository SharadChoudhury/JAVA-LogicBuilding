package SearchingSorting;

public class sort_012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//time complexity:O(n)
		//space complexity= O(1)
		int arr[] ={1,2,0,2,1,0,0,1};
		int n = arr.length;
        int c0=0;
        int c1=0;
        
        for(int i=0;i<n;i++){
            if(arr[i]==0)
                c0++;
            if(arr[i]==1)
                c1++;
        }
    	
        int i=0;
        for(;i<c0;i++)
            arr[i]=0;
        for(;i<c0+c1;i++)
            arr[i]=1;
        for(;i<n;i++)
            arr[i]=2;
        
        for(int j:arr)
        	System.out.print(j+" ");

	}

}
