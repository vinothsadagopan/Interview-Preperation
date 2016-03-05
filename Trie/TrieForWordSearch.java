/*
	Top coder solution for Trie based problem
	Problem Statement
    	
You have been given a "word search" puzzle, which consists of a rectangular grid of letters, in which several words are hidden. Each word may begin anywhere in the puzzle, and may be oriented in any straight line horizontally, vertically, or diagonally. However, the words must all go down, right, or down-right. (see examples)

You are given a String[], grid, indicating the letters in the grid to be searched. Character j of element i of grid is the letter at row i, column j. You are also given a String[], wordList, indicating the words to be found in the grid. You are to return a String[] indicating the locations of each word within the grid.

The return value should have the same number of elements as wordList. Each element of wordList corresponds to the element of the return value with the same index.

Each element of the return value should be formatted as "row col" (quotes added for clarity), where row is the 0-based row in which the first letter of the word is found, and col is the 0-based column in which the first letter of the word is found. If the same word can be found more than once, the location in the lowest-indexed row should be returned. If there is still a tie, return the location with the lowest-indexed column. If a word cannot be found in the grid, return an empty string for that element.

 
Definition
    	
Class:	WordFind
Method:	findWords
Parameters:	String[], String[]
Returns:	String[]
Method signature:	String[] findWords(String[] grid, String[] wordList)
(be sure your method is public)
    
 
Constraints
-	grid will contain between 1 and 50 elements, inclusive.
-	Each element of grid will contain between 1 and 50 characters, inclusive.
-	Each element of grid will contain the same number of characters.
-	Each character of each element of grid will be 'A'-'Z'.
-	wordList will contain between 1 and 50 elements, inclusive.
-	Each element of wordList will contain between 1 and 50 characters, inclusive.
-	Each character of each element of wordList will be 'A'-'Z'.
 
Examples
0)	
    	
{"TEST",
 "GOAT",
 "BOAT"}
{"GOAT", "BOAT", "TEST"}
Returns: { "1 0",
  "2 0",
  "0 0" }
These words are pretty easy to find.
1)	
    	
{"SXXX",
 "XQXM",
 "XXLA",
 "XXXR"}
{"SQL", "RAM"}
Returns: { "0 0",
  "" }
While "RAM" may be found going up at "3 3", we are only allowing words that go down and right.
2)	
    	
{"EASYTOFINDEAGSRVHOTCJYG",
 "FLVENKDHCESOXXXXFAGJKEO",
 "YHEDYNAIRQGIZECGXQLKDBI",
 "DEIJFKABAQSIHSNDLOMYJIN",
 "CKXINIMMNGRNSNRGIWQLWOG",
 "VOFQDROQGCWDKOUYRAFUCDO",
 "PFLXWTYKOITSURQJGEGSPGG"}
{"EASYTOFIND", "DIAG", "GOING", "THISISTOOLONGTOFITINTHISPUZZLE"}
Returns: { "0 0",
  "1 6",
  "0 22",
  "" }
*/
public class TrieForWordSearch {
	public static TrieNode root = null;
	TrieForWordSearch() {
		this.root = new TrieNode(null, false);
	}
	public void insert(String key, Index index) {
		if(key==null) return;
		int count=0;
		key=key.toLowerCase();
		TrieNode current = root;
		while(count< key.length()) {
			int charIndex = getIndex(key.charAt(count));
			if(charIndex<0 || charIndex>25) {
				System.out.println("invalid key");
				return;
			}
			if(current.children[charIndex]==null) {
				current.children[charIndex]= new TrieNode(null, false);
			}
			current = current.children[charIndex];
			count++;
		}
		current.markAsLeaf(index);
		
	}
	public Index search(String key) {
		if(key==null) {
			return null;
		}
		int count =0;
		TrieNode current = root;
		while(count< key.length() && current!=null) {
			int charIndex = getIndex(key.charAt(count));
			if(charIndex<0 || charIndex>25) {
				System.out.println("invalid key");
				return null;
			}
			if(current.children[charIndex]!=null) {
				current = current.children[charIndex];
			}
			count++;
		}
		if(current!=null) {
			return current.index;
		}
		return null;
	}
	public int getIndex(char ch) {
		return ch-'a';
	}
	public void addWordsToTrie(char[][]letters) {
		boolean[][] letterBool= new boolean[letters.length][letters[0].length];
		addWordsToTrie(letters, 0, 0, letterBool);
	}
	public void addWordsToTrie(char[][] letters, int i, int j, boolean[][] letterBool) {
		if(i<0||i>letters.length-1||j<0||j>letters[0].length-1) {
			return;
		}
		//System.out.println("Printing i "+i);
		//System.out.println("Printing j "+j);
		if(!letterBool[i][j]) {
			int x= i;
			int y = j;
			StringBuilder sb = new StringBuilder();
			// Framing the right words.
			
			while(y<letters[0].length) {
				sb.append(letters[i][y]);
				y++;
			}
			insert(sb.toString(),new Index(i,j));
			sb.setLength(0);
			//Faming words with down letters 
			while(x<letters.length) {
				sb.append(letters[x][j]);
				x++;
			}
			insert(sb.toString(),new Index(i,j));
			sb.setLength(0);
			//Framing diagonal word with letters
			x=i;y=j;
			while(x<letters.length && y< letters[0].length) {
				sb.append(letters[x][y]);
				x++;
				y++;
			}
			insert(sb.toString(),new Index(i,j));
			sb.setLength(0);
			letterBool[i][j]=true;
			addWordsToTrie(letters, i,j+1,letterBool);
			addWordsToTrie(letters,i+1,j,letterBool);
		}

	}
	public String[] searchWord(String[] list) {
		String[] output = new String[list.length];
		int count=0;
		for(String word:list) {
			Index id = search(word);
			if(id!=null) {
				output[count++] = id.toString();
			}
		}
		return output;
	}
	public static void main(String[] args) {
		char[][] letters = {
			{'s','x','x','x'},
			{'x','q','x','m'},
			{'x','x','l','a'},
			{'x','x','x','r'}

		};
		String[] wordList = {"sql","ram"};
		TrieForWordSearch trie = new TrieForWordSearch();
		trie.addWordsToTrie(letters);
		String[] output = trie.searchWord(wordList);
		for(String word: output) {
			System.out.println(word);	
		}
		
	}
}
class TrieNode {
	Index index; 
	boolean isLeafNode;
	TrieNode[] children;
	TrieNode(Index index, boolean isLeafNode) {
		this.index=index;
		this.isLeafNode=isLeafNode;
		this.children= new TrieNode[26];
	}
	public void markAsLeaf(Index index) {
		this.isLeafNode=true;
		this.index=index;
	}

}
 class Index {
	int i,j;
	Index(int i, int j) {
		this.i=i;
		this.j=j;
	}
	public String toString() {
		return i+" "+j;
	}
}