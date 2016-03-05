class TrieNode {
	int value;
	boolean isLeafNode;
	TrieNode[] children;
	TrieNode(int value, boolean isLeafNode) {
		this.value =value;
		this.isLeafNode = isLeafNode;
		this.children= new TrieNode[26];

	}
	public void markAsLeaf(int value) {
		this.value= value;
		this.isLeafNode=true;
	}
}