package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree {
	TreeNode root = null;
	public void insertFromArray(int[]inputarray) {
		for(int i =0; i< inputarray.length;i++ ) {
			//System.out.println(inputarray[i]);
			insert(inputarray[i]);
		}
	}
	public void insert(int data) {
		root = insert(root,data);
	}
	public TreeNode insert(TreeNode roots,int data){
		if(roots == null) {
			roots = new TreeNode(data);
		}
		else if(data < roots.data)roots.left =insert(roots.left,data);
		else if(data > roots.data)roots.right=insert(roots.right,data);
		
		return roots;
	}
	public void printTree() {
		printTree(root);
	}
	public void printTree(TreeNode root) {
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
	public int size() {
		return size(root);
	}
	public int size(TreeNode root) {
		if(root == null)return 0;
		else {
			return 1+size(root.left)+size(root.right);
		}
		
		
	}
	public int depth(){
		return depth(root);
	}
	public int depth(TreeNode root) {
		if (root == null) return 0;
		else
			return 1+Math.max(depth(root.left),depth(root.right));
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] inputarray = {10,8,7,9,14,12,16,19};
		bst.insertFromArray(inputarray);
		/*bst.insert(10);
		bst.insert(8);
		bst.insert(7);
		bst.insert(9);
		bst.insert(14);
		bst.insert(12);
		bst.insert(16); */
		bst.printTree();
		System.out.println("Size of a tree is :"+bst.size());
		System.out.println("Depth of a tree is :"+bst.depth());
		
		
	}
	
	
}
