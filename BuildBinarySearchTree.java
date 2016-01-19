/*
 * TO build Binary Search Tree from given input sorted array(increasing order).
 * */

package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class BuildBinarySearchTree {
	static TreeNode buildBST (int[] input,int start, int end) {
		if(start>end) return null;
		
		int mid = (end+start)/2;
		System.out.println("printing mid value"+input[mid]);
		TreeNode node= new TreeNode(input[mid]);
	    if(start == end) return node;
	    else {
	    	node.left = buildBST(input,start,mid-1);
	    	node.right = buildBST(input, mid+1, end);
	    	return node;
	    }
		
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
	public static void main(String[] args) {
	int[] input = {1,2,3,4,5,6,7,8,9};
	TreeNode root = buildBST(input,0,input.length-1);
	printTree(root);

	}

}
