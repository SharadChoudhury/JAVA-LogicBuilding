package stacks;

import java.util.Stack;

public class minBracketReversalForBalanced {
	
	public static int countBracketReversals(String input) {
		//Time:O(n)			space:O(n)
        
        if(input.length() % 2==1)// odd length cannot be balanced
            return -1;
        
        Stack<Character> stack= new Stack<>();
        int i=0;
        
        for(i=0; i<input.length() ;i++){
            
            if( input.charAt(i)=='{' )		//opening bracket
               	stack.push(input.charAt(i));
            
            else{							//closing bracket
                if(stack.isEmpty())
                    stack.push(input.charAt(i));
                else{
                    if( stack.peek()=='{' ){
                        stack.pop();
                    }
                    else{
                        stack.push(input.charAt(i));
                    }
                }               
            }
            
        }
        
        int cnt=0;
        while(!stack.isEmpty()){
            char a= stack.pop();
            char b= stack.pop();
            
            if(a==b)
                cnt +=1 ;
            else
                cnt +=2 ;
        }
        
        return cnt;
	}
	
}
