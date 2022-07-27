package stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
public class BalancedParanthesis {
	
	public static boolean isBalanced(String expression) {
        //Time:O(n)		space:O(n)
		
        int len= expression.length(); 
        
        if(len==0)
        	return true;
        
        Stack<Character> stack= new Stack<Character>();        
        int i=0;
        
        for(i=0; i<len ; i++){
        	
        	if( expression.charAt(i)=='(' || expression.charAt(i)=='{') {
        		stack.push(expression.charAt(i));
            	continue;
        	}
        	
        	//the below conditions must be checked while i<len to handle special cases like
        	// {}() , so that opening brackets can be pushed again if required
        	
        	if(stack.isEmpty()){ //starts with closing brackets
	            return false;
	        }
        	
        	if(expression.charAt(i)==')'){
                if( stack.pop()!= '(' )
                    return false;             
        	}
        	else {
        		if(stack.pop()!='{' )
                    return false;
        	}
            
        }        
        
        return stack.isEmpty(); // in balanced cases, the stack will be empty
        
    }
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(isBalanced(expression));
    }

}
