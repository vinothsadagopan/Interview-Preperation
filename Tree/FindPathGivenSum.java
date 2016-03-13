package com.datastructures;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindPathGivenSum {
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
	public static boolean PathForGivenSum(int sum) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		return PathForGivenSum(root,sum,list);
	}
	public static boolean PathForGivenSum(TreeNode root, int sum,List<TreeNode> list) {
		
		if(root == null){
			return false;
		}
		list.add(root);
		if(root.left == null && root.right == null) {
			if(root.data == sum) {
				return true;
			}
			else {
				list.remove(list.size() -1);
				return false;
			}
				
		}
		else {
			return PathForGivenSum(root.left,sum-root.data,list)||PathForGivenSum(root.right,sum-root.data,list);
		}
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]inputarray={10,8,7,9,14,12,16,19};
		for(int n:inputarray) insert(n);
		printTree();
		System.out.println(PathForGivenSum(28));

	}

}
