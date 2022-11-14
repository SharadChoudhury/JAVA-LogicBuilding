package priorityQueue;

import java.util.*;

class Triplet{
    int ele;
    int indexinarray;
    int kofarray;

    Triplet(int x,int y,int z){
        ele = x;
        indexinarray = y;
        kofarray = z;
    }
}

class tripletcomp implements Comparator<Triplet>{

	@Override
	public int compare(Triplet o1, Triplet o2) {
		// TODO Auto-generated method stub
		if(o1.ele < o2.ele)
			return -1;
		else if(o1.ele > o2.ele)
			return 1;
		else
			return 0;
	}   
}

public class mergeKsortedArr {
	
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {


		ArrayList<Integer> ans = new ArrayList<>();
		tripletcomp comparator = new tripletcomp();
        int k = input.size();
        PriorityQueue<Triplet> pq = new PriorityQueue<>(comparator);
        
        int i=0; 
        
        //first add the zeroth element from all k arrays into the min-heap
        for(i=0 ; i<k ; i++) {
        	pq.add(new Triplet(input.get(i).get(0) , 0 , i));
        }
   
        while(!pq.isEmpty()) {
        	
        	Triplet min = pq.poll();
        	ans.add(min.ele);
        	int kofmin = min.kofarray;
        	int next = min.indexinarray + 1;       	

            if(next < input.get(kofmin).size()) { 
                pq.add(new Triplet( input.get(kofmin).get(next) , next , kofmin ));
            }
        	
        }
        
        return ans;
        
	}

	
}
