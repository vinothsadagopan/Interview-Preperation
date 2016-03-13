/*
 * Program to find if two nodes in binary tree are cousins of each other? 
 * */

package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class CousinNodes {
	static TreeNode root=null;
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
	public static boolean isCousin(int data1, int data2) {
		return isCousin( root, data1,data2);
		
	}
	public static int level(TreeNode root, int data, int level) {
		if(root == null) return 0;
		if(root.data == data) return level;
		int l = level(root.left, data, level+1);
		if(l!=0)return l;
		else return level(root.right,data,level+1);
		
	}
	public static TreeNode findNode(TreeNode root,int data) {
		if(root== null) return null;
		if(root.data==data) return root;
		TreeNode temp = findNode(root.left,data);
		if(temp!=null) return temp;
		else
			return findNode(root.right,data);
		
	}
	public static boolean isSibling(int data1, int data2) {
		TreeNode n1 = findNode(root,data1);
		TreeNode n2 = findNode(root,data2);
		return isSibling(root,n1, n2);
	}
	public static boolean isSibling(TreeNode root, TreeNode n1,TreeNode n2) {
		if (root==null) return false;
		
		if(root.left==n1 && root.right==n2 || root.left == n2 && root.right == n1) {
			return true;
		}
		else {
			return isSibling(root.left,n1,n2) || isSibling(root.right,n1,n2);
		}
	}
	public static boolean isCousin(TreeNode root, int data1,int data2) {
		if(root == null) return false;
		else if ((level(root,data1,1)==level(root,data2,1))&&(!isSibling(data1,data2))) return true;
		else return false;
		
		
	
	}
	public static void main(String[] args) {
		int[] inputarray ={8,3,1,4,10,9,11};
		for(int n:inputarray) insert(n);
		System.out.println("Are 1 and 11 cousins ?"+isCousin(1,11));
		System.out.println("Are 1 and 10 cousins ?"+isCousin(1,10));
		System.out.println("Are 1 and 4 cosuins ?"+isCousin(1,4));

	}

}
