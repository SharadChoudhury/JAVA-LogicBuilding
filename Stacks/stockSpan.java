package stacks;
import java.util.*;

public class stockSpan {
	
	public static int[] StockSpan(int[] price) {
		
		int[] ans= new int[price.length];
        
        Stack<Integer> stack=  new Stack<>();

        int i;
        
//        for(i=0; i<price.length; i++) {
//            
//        	if(stack.isEmpty()) {
//        		stack.push(i);
//        		ans[i]=1;
//        	}
//        	
//        	else if(price[stack.peek()] < price[i]) {
//                
//        		while( !stack.isEmpty() &&	price[stack.peek()] < price[i]	) {
//            		stack.pop();
//            	}
//                
//                if(stack.isEmpty()){
//                    ans[i]=i+1;
//                    stack.push(i);
//                }
//                else{
//                    ans[i] = i - stack.peek();
//            		stack.push(i);
//                }
//            	
//        	}
//            
//        	else {
//        		ans[i]= i- stack.peek();  // or ans[i]=1
//        		stack.push(i);
//        	}       	
//        		
//        }
        
        for(i=0; i<price.length; i++) {
            
            while( !stack.isEmpty() &&	price[stack.peek()] < price[i]	) {
                stack.pop();
            }

            if(stack.isEmpty())
                ans[i]=i+1;
            else
                ans[i] = i - stack.peek();

            stack.push(i);	
	
        }
        
        return ans;
        
	}
	
}
