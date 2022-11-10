package Tries;

import java.util.ArrayList;

//class TrieNode{
//	char data;
//	boolean isTerminating;
//	TrieNode children[];
//	int childCount;
//
//	public TrieNode(char data) {
//		this.data = data;
//		isTerminating = false;
//		children = new TrieNode[26];
//		childCount = 0;
//	}
//}

public class AutoComplete {
	private TrieNode root;
	public int count;
	public AutoComplete() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
	
	
	// ---------------------------  Auto Complete  ------------------------------------------
	
	public void autoComplete(ArrayList<String> input, String word) {

        for(String str : input){
            add(str);
        }
		
        TrieNode temp = root;
        TrieNode child = null;
        
        for(int i = 0; i< word.length() ; i++){
            child = temp.children[word.charAt(i) - 'a'];
            if(child == null)
                return ;
        	temp = child;
        }
        
       	if( child.isTerminating ){
            System.out.println(word);
        } 
        autocomplete(temp,word);
    }
    
    private void autocomplete(TrieNode root, String word){
        
        if(root.childCount > 0){   
            
            for(TrieNode child : root.children){              
                if(child != null ){
                    if(child.isTerminating){
                        word = word + child.data;
                        System.out.println(word); 
                    }                       
                    autocomplete(child,word); 
                }              
            }     
            
        }
        
    }
    
    

}