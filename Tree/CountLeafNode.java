/*
 To count number of leaf nodes in a given BT.
*/

class CountLeafNode {
	public static TreeNode root = null;
	public static int countLeaf =0;
	public static int countLeafs() {
		return countLeafs(root);
	}
	public static int countLeafs(TreeNode root) {
		if(root == null) return -1;
		else {
			int left = countLeafs(root.left);
			int right = countLeafs(root.right);
			if(left== -1 && right ==-1) {
				countLeaf++;
			}
		}
		return countLeaf;
	}
	public static void insert(int data) {
		root = insert(root, data);
	}
	public static TreeNode insert(TreeNode root, int data) {
		if(root == null) root = new TreeNode(data);
		if(data < root.data) root.left = insert(root.left, data);
		else if(data > root.data) root.right = insert(root.right, data);
		return root;
	}
	public static void main(String[] args) {
		int[] inputArray = {4,2,1,3,6,5,};
		for (int n :inputArray ) {
			insert(n);
		}
		System.out.println("Number of leaf nodes in the tree are :"+countLeafs());

	}
}
