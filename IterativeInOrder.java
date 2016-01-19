/*
	Function to print Inorder iteratively in BT
*/

import java.util.Deque;
import java.util.LinkedList;
class IterativeInOrder {
	public static TreeNode root = null;
	public static void insert(int data) {
		root =insert(root,data);
	}
	public static TreeNode insert(TreeNode root, int data) {
		if(root == null) root = new TreeNode(data);
		else if(data < root.data) root.left = insert(root.left,data);
		else root.right = insert(root.right,data);
		return root;
	}
	public static void printInorder() {
		printInorder(root);
	}
	public static void printInorder(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode current =root;
		while(true) {
			
			if(current!=null) {
				stack.addFirst(current);
				current = current.left;
			}
			else  {
				 if(stack.isEmpty()) break;
				 else {
				 	current = stack.removeFirst();
				 	System.out.println(current.data);
				 	current= current.right;
				 }
			}

		}
	}
	public static void main(String[] args) {
		int[] inputArray ={20,8,22,4,12,22,26};
		for(int n: inputArray) {
			insert(n);
		}
		printInorder();
		
	}
}