/*
 * TO build BST from inorder and postorder tree traversal.
 * */
package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeFromInorderPostOrder {
	public static TreeNode root =null;
	public static int postIndex;	
	public static TreeNode buildTree(int[]in, int[]post) {
		int inStart = 0;
		int inEnd = in.length -1;
	    postIndex = post.length -1;
		return buildTree(in,post,inStart, inEnd);
				
		
	}
	public static int findIndex(int[]in, int value) {
		int i;
		for( i=0; i< in.length;i++) {
			if(in[i]== value) return i; 
		}
		return i;
	}
	public static TreeNode buildTree(int[]in, int[]post, int inStart, int inEnd) {
		if(inStart > inEnd) return null;
		TreeNode node = new TreeNode(post[postIndex--]);
		if(inStart == inEnd) return node;
		int inIndex = findIndex(in, node.data);
		node.right = buildTree(in,post, inIndex+1,inEnd);
		node.left = buildTree(in,post,inStart,inIndex-1);
		return node;
	}
	//utility functions
	
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
	
	public static void main(String[] args) {
		int[] postOrder ={1,4,3,9,11,10,8};
		int[] inOrder = {1,3,4,8,9,10,11};
		root = buildTree(inOrder,postOrder);
		printTree(root);
	}

}
