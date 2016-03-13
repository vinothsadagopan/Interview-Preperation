/*
 * To find whether Tree T2 is sub tree of T1 
 * */
package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class SubTree {
	static TreeNode root = null;
	static boolean isIdentical(TreeNode t1, TreeNode t2) {
		if(t1== null && t2== null) return true;
		if(t1== null || t2== null) return false;
		return (t1.data == t2.data)&& isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
	}
	static boolean isSubTree(TreeNode t1, TreeNode t2) {
		if(t2== null) return true;
		if(t1== null) return false;
		if(isIdentical(t1,t2)) return true;
		else return isIdentical(t1.left,t2) || isIdentical(t1,t2);
	}
	
	// Utility Functions - Insert and Print 
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
	// Utility Functions ends
	
	public static void main(String[] args) {
		

	}

}
