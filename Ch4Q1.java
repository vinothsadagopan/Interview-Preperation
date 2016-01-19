/*Question: To implement a function that checks if Binary tree is balanced or not.
 * 
 * */


package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class Ch4Q1 {

	static TreeNode root= null;
	
	//Function which checks for the height
	public static int getHeight() {
		return getHeight(root);
	}
	public static int getHeight(TreeNode root) {
		  if (root == null) return 0; // Base case
		  return Math.max(getHeight(root.left) ,getHeight(root.right) )  + 1;
	}
	public static boolean isBalanced() {
		return isBalanced(root);
	}
	public static boolean isBalanced(TreeNode root)  {
		 if (root == null)  return true;  // Base case
		
		 int heightDiff = getHeight(root.left)  - getHeight(root.right) ;
		 if (Math.abs(heightDiff)  > 1)  {
			 return false;
		 }  else {  //  Recurse
			 return isBalanced(root.left)  && isBalanced(root.right) ;
		 }
	}
	
	
	//Utility functions: to insert and print tree
	public static void insert(int data) {
		root = insert(root,data);
	}
	public static TreeNode insert(TreeNode roots,int data){
		if(roots == null) {
			roots = new TreeNode(data);
		}
		else if(data < roots.data)roots.left =insert(roots.left,data);
		else if(data > roots.data)roots.right=insert(roots.right,data);
		
		return roots;
	}
	public static void printTree(){
		printTree(root);
	}
	public static void printTree(TreeNode root) {
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addFirst(root);
		queue.addLast(null);
		//System.out.println(root.left.data);
		while(!queue.isEmpty()){
			TreeNode curr = queue.removeFirst();
			if(curr == null ) {
				if(queue.isEmpty()){
					break;
				}
				else {
					System.out.println();
					queue.addLast(null);
				}
				
			}
			
			else {
				System.out.print(curr.data+" ");
				if(curr.left !=null)queue.addLast(curr.left);
				if(curr.right!=null)queue.addLast(curr.right);
				
			}
		}
	}
	// End-- Utility Functions--> Insert and Printing binary tree
	public static void main(String[] args) {
		int[]inputarray={12,8,7,9,10,16,14};
		//int[]inputarray={10,8,7,9,14,12,16,19};
		for(int n:inputarray) insert(n);
		printTree();
		System.out.println("Height of the tree "+getHeight());
		System.out.println("Is the tree balanced ?"+isBalanced());
		
	}

}
