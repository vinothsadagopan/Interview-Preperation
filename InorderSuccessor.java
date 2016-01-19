/*
 * To find inorder successor for a given Binary Search tree
 * */

package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class InorderSuccessor {

	static TreeNode root= null;
	static TreeNode FindNode(TreeNode root, int value) {
	    if(root == null) return null;
	    else if(root.data == value ) return root;
		else if(root.data< value)return FindNode(root.right,value);
		else return FindNode(root.left, value);
	}
	static TreeNode inorderSuccessor(int value) {
		return inorderSuccessor(root,value);
	}
	static TreeNode inorderSuccessor(TreeNode root,int value) {
		if(root == null) return null;
		TreeNode current = FindNode(root, value);
		if(current == null) return null;
		else if(current.right!=null) {
			 
				TreeNode temp = current.right;
				while(temp.left!=null) temp = temp.left;
				return temp; 
			
		}
		else {
			TreeNode temp = root;
			TreeNode  successor = null;
			while(temp!=current) {
				if(temp.data > current.data) {
					successor = temp; 
					temp= temp.left;
				}
				else temp = temp.right;
			}
			return successor;
			
		}
		
	}
	
	//Utility Functions - Insert and Print tree functions
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
		int[]inputarray={10,8,7,9,14,12,16,19};
		for(int n:inputarray) insert(n);
		printTree();
		int value =12;
		System.out.println("Printing inorder successor of 12 "+inorderSuccessor(value).data);
		System.out.println("Printing inorder successor of 10 "+inorderSuccessor(10).data);
		System.out.println("Printing inorder successor of 9 "+inorderSuccessor(9).data);

	}

}
