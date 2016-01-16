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
	public static boolean isCousin(TreeNode root, int data1,int data2) {
		Deque<TreeNode> list = new LinkedList<TreeNode>();
		list.addFirst(root);
		list.addLast(null);
		boolean flag1 = false;
		boolean flag2 = false;
		while(!list.isEmpty()) {
			TreeNode temp = list.removeFirst();
			if(temp==null) {
				if(list.isEmpty()) break;
				else if(flag1 && flag2 ||flag1 && !flag2 || !flag1 && flag2) break;
				else list.addLast(null);
									
			}
			else {
				if(temp.data == data1) flag1= true;
				if(temp.data == data2) flag2 = true;
				if(temp.left!=null) list.addLast(temp.left);
				if(temp.right!=null)list.addLast(temp.right);

			}
		}
		return(flag1 && flag2);
	}
	public static void main(String[] args) {
		int[] inputarray ={8,3,1,4,10,9,11};
		for(int n:inputarray) insert(n);
		System.out.println("Are 1 and 11 cousins ?"+isCousin(1,11));
		System.out.println("Are 1 and 10 cousins ?"+isCousin(1,10));

	}

}
