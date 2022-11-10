package Tries;

import java.util.ArrayList;

//class TrieNode {
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

public class palindromePair  {

	private TrieNode root;
	public int count;

	public palindromePair () {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */
	
    public String reverse(String word){
        String result = "";
        for(int i=0 ; i< word.length() ; i++){
			result  = word.charAt(i) + result;
        }
        return result;
    }

	public boolean isPalindromePair(ArrayList<String> words) {
        for(String s: words){
            for(int i =0; i< s.length(); i++){
                add(s.substring(i));
                add(s.substring(0,s.length()-i));
            }
                
        }
        
        for(String s: words){
            if(search(s) && search(reverse(s)))
                return true;
        }
            
         return false;   
	}


	
} 