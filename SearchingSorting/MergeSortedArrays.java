package SearchingSorting;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1= {1,3,7,9};
		int[] arr2= {0,2,3,5,7,8};
	
// time complexity for merging: O(l1+l2)
// Space complexity for merging: O(l1+l2)
		
        int l1=arr1.length;
        int l2=arr2.length;
        int l3=l1+l2;
        
        int arr3[]=new int[l3];
        int i=0,j=0,k=0;
        
        while(i<l1 && j<l2){          
            if(arr1[i]<arr2[j] ){
                arr3[k]=arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k]=arr2[j];
                j++;
                k++;
            }
        }
        
        while(i<l1){
            arr3[k]=arr1[i];
            i++;
            k++;
        }
        
        while(j<l2){
            arr3[k]=arr2[j];
            j++;
            k++;
        }
        
        for(int ele:arr3)
        	System.out.print(ele+" ");
	}

}
