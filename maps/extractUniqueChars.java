package maps;
import java.util.*;
public class extractUniqueChars {
	
	public static String uniqueChar(String str){

        String s="";
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,1);
                s = s + ch;
            }               
        }
        
        return s;

	}
	
}
