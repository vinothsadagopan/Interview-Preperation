/*
 * Building Binary Search Tree Using Pre- order and in-order
 */

package com.datastructures;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree {
		TreeNode  root= null;
		static int preIndex =0;
	// ----Print Tree Starts-----
		public void printTree() {
			printTree(root);
		}
		public void printTree(TreeNode root) {
			Deque<TreeNode> queue = new LinkedList<TreeNode>();
			queue.addFirst(root);
			queue.addLast(null);
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
		//-----Print Tree Ends----
		//Building Tree using pre order and in order
		public TreeNode buildTree(int[]pre, int[]in,int inStart, int inEnd) {
			if(inStart> inEnd) {
				return null;
			}
			//System.out.println(pre[preIndex]);
			TreeNode node = new TreeNode(pre[preIndex++]);
			if(inStart == inEnd) {
				return node;
			}
			int index = searchIndex(in,node.data);
			//System.out.println(index);
			node.left = buildTree(pre, in, inStart,index-1);
			node.right = buildTree(pre,in, index+1, inEnd);
			return node;
		}
		public int searchIndex(int[]in, int value) {
			int i;
			for( i =0; i<in.length;i++){
				if(in[i]==value) return i;
			}
			return i;
			
		
		}

	public static void main(String[] args) {
		int[] preOrderArray = {10,8,7,9,14,12,16};
		int[] inOrderArray =  {7,8,9,10,12,14,16};
		BinaryTree BT = new BinaryTree();
		//System.out.println(inOrderArray.length -1);
		TreeNode root = BT.buildTree(preOrderArray, inOrderArray, 0, inOrderArray.length -1);
		BT.printTree(root);

	}

}
