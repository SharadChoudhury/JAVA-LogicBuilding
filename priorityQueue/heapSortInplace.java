package priorityQueue;

public class heapSortInplace {
	
	public static void inplaceHeapSort(int arr[]) {
        
        //insert into virtual heap
        for(int i=0; i< arr.length; i++){           
            int childIndex = i;
            int parentIndex = (childIndex - 1) / 2;

            while (childIndex > 0) {                
                if (arr[childIndex] < arr[parentIndex]) {                    
                    int temp = arr[childIndex];
					arr[childIndex] = arr[parentIndex];
                    arr[parentIndex] = temp;
                    
                    childIndex = parentIndex;
                    parentIndex = (childIndex - 1) / 2;
                    
                } 
                else 
                    break;
            }  
            
        }
        
        //remove from virtual heap
        int len = arr.length;
        
        for(int i=0; i< arr.length; i++){       	
        	//first swap first element with last element and reduce len
            int temp = arr[len-1];
            arr[len-1] = arr[0];
            arr[0] = temp;
            len--; //now your heap is only from index 0 to index len-1
            
            //after inserting the last element at 0th index, down-heapify to maintain HOP
            int parent = 0;
            int minIndex;
            int leftchild = 1;
            int rightchild = 2;
            
            while(leftchild < len ){
                //find minIndex
                minIndex = parent;  //assume parent as minimum
                
                //if left element is smaller than minimum yet(i.e parent)
                if(arr[leftchild] < arr[minIndex])
                    minIndex = leftchild;
                
                //if right is smaller than parent & left element(minimum yet among parent & left)
                if(rightchild<len && arr[rightchild] < arr[minIndex]) //cannot use 'else-if' here
                    minIndex = rightchild;
                
                //swapping parent with minIndex element
                if(minIndex != parent){
                   	int temp1= arr[minIndex];
                    arr[minIndex] = arr[parent];
                    arr[parent] = temp1;

                    //change parent and child
                    parent = minIndex;		//since parent was swapped with element at minIndex
                    leftchild = 2*parent + 1;
                    rightchild = 2*parent + 2; 
                }
                else
                    break;
                
            }            
        }

    }
	
}
