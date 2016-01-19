/*
To Print Postorder of a binary tree iteratively
*/

import java.util.Deque;
import java.util.LinkedList;
class IterativePostOrder {
	static TreeNode root = null;
	public static void insert(int data) {
		root =insert(root,data);
	}
	public static TreeNode insert(TreeNode root, int data) {
		if(root == null) root = new TreeNode(data);
		else if(data < root.data) root.left = insert(root.left,data);
		else root.right = insert(root.right,data);
		return root;
	}
	public static void printPostOrder() {
		printPostOrder(root);
	}
	public static void printPostOrder(TreeNode root) {
		Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
		Deque<TreeNode> stack2 = new LinkedList<TreeNode>();
		stack1.addFirst(root);
		while(!stack1.isEmpty()) {
			TreeNode current = stack1.removeFirst();
			if(current.left!=null) stack1.addFirst(current.left);
			if(current.right!=null) stack1.addFirst(current.right);
			stack2.addFirst(current);
		}
		while(!stack2.isEmpty()) {
			TreeNode current = stack2.removeFirst();
			System.out.println(current.data);
		}
	}
	public static void main(String[] args) {
		int[] inputArray= {20,8,14,26,2,24,28};
		for(int n: inputArray) {
			insert(n);
		}
		printPostOrder();
		
	}
}
