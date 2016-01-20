/*
	Program to Print Iterative Pre Order traversal of BT
*/
import java.util.Deque;
import java.util.LinkedList;

class IterativePreOrder {
	static TreeNode root =null;
	public static void insert(int data) {
		root =insert(root,data);
	}
	public static TreeNode insert(TreeNode root, int data) {
		if(root == null) root = new TreeNode(data);
		else if(data < root.data) root.left = insert(root.left,data);
		else root.right = insert(root.right,data);
		return root;
	}
	public static void printPreOrder() {
		printPreOrder(root);
	}
	public static void printPreOrder(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(root);
		
		while(!stack.isEmpty()) {
			TreeNode current = stack.removeFirst();
			System.out.println(current.data);
			if(current.right!=null) stack.addFirst(current.right);
			if(current.left!=null) stack.addFirst(current.left);
		}

	} 

	public static void main(String[] args) {
		int[] inputArray ={20,8,22,4,12,22,26};
		for(int n: inputArray) {
			insert(n);
		}
		printPreOrder();
	}
}