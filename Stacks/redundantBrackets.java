package stacks;

import java.util.Stack;

public class redundantBrackets {
	
	public static boolean checkRedundantBrackets(String expression) {
		//Time:O(n)			space:O(n)
        
        Stack<Character> stack= new Stack<Character>();        
        int i=0;
        
        while(i< expression.length() ){
        	
        //push all elements except closing brackets   
            if(expression.charAt(i)!=')'  &&  expression.charAt(i)!='}'){
                stack.push(expression.charAt(i));
                i++;
                continue;
            }
        
        //cnt holds the no. of characters between opening and closing brackets
            int cnt=0;
            
        //once we encounter a closing bracket,increase cnt while popping each 
        //element from stack till its corresponding opening bracket is found 
            if(expression.charAt(i)==')'){
                while( stack.pop()!='(' ){
                    cnt++;
                }
            }
            else{
                while( stack.pop()!='{' ){
                    cnt++;
                }
            }
    
            //if cnt<=1 , brackets are useless
            if(cnt<=1)
                return true;
            
            i++;
        }
        
        return false;
        
	}
	
}
