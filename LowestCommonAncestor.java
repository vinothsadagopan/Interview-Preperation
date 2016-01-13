package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class LowestCommonAncestor {
	static TreeNode root= null;
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
	public static int LCA (int data1, int data2 ) {
		return LCA(root,data1,data2).data;
	}
	public static TreeNode LCA(TreeNode root, int data1,int data2) {
		if(root == null) return null;
		else if(root.data< data1 && root.data <data2) return LCA(root.right, data1,data2);
		else if(root.data> data1 && root.data>data2) return LCA(root.left,data1,data2);
		else return root;
		
	}

	public static void main(String[] args) {
		int[]inputarray={10,8,7,9,14,12,16,19};
		for(int n:inputarray) insert(n);
		printTree();
		System.out.println("printing LCA of 16 and 19 is "+LCA(16,19));

	}

}
