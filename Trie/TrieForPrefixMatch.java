class TrieForPrefixMatch {
	TrieNode root = null;
	TrieForPrefixMatch() {
		root = new TrieNode(-1, false);
	}
	public void insert(String key, int value) {

		if(key==null) return;
		TrieNode current = this.root;
		int count =0; 
		while(count< key.length()) {
			int charIndex = getIndex(key.charAt(count));
			if(charIndex<0|| charIndex>26) {
				System.out.println("Invalid character");
				return;
			}
			if(current.children[charIndex]==null) {
				current.children[charIndex] = new TrieNode(-1, false);
			}
			current = current.children[charIndex];
			count++;
		}
		current.markAsLeaf(value);

	}
	public String longestPrefix(String input) {
		return longestPrefix(root, input);
	}
	public String longestPrefix(TrieNode root, String input) {
		TrieNode current = root;
		if(input== null) return "";
		String longestCharSeq ="";
		String longestMatchedWord="";
		int count =0;
		while(count<input.length()) {
			if(current==null) break;
			current = current.children[getIndex(input.charAt(count))];
			if(current!=null) {
				longestCharSeq += input.charAt(count);
				if(current.isLeafNode) {
					longestMatchedWord= longestCharSeq;
				}
			}
			count++;
		}
		return longestMatchedWord;

	}
	public int getIndex(char c) {
		
		return c -'a';
	}
	public static void main(String[] args) {
		TrieForPrefixMatch trie = new TrieForPrefixMatch();
		trie.insert("cam",3);
		trie.insert("cat",4);
		System.out.println("Longest for the prefix match  camera is "+trie.longestPrefix("camera"));

	}
}