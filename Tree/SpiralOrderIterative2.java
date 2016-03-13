
/*
	To print level order traversal of binary tree in spiral form using Deque data structure.

*/
import java.util.Deque;
import java.util.LinkedList;
class SpiralOrderIterative2{
	public static TreeNode root = null;
	public static void printSpiral(TreeNode root) {
		Deque<TreeNode> st1 = new LinkedList<TreeNode>();
		st1.addFirst(null);
		st1.addFirst(root);
		while(true) {
			while(st1.peekFirst()!=null) {
				TreeNode temp = st1.removeFirst();
				if(temp.left!=null) st1.addLast(temp.left);
				if(temp.right!=null) st1.addLast(temp.right);
				System.out.print(temp.data+" ");
			}
			while(st1.peekLast()!=null) {
				TreeNode temp = st1.removeLast();
				if(temp.right!=null) st1.addFirst(temp.right);
				if(temp.left!=null) st1.addFirst(temp.left);
				System.out.print(temp.data+" ");
			}
			if(st1.peekFirst()==null && st1.peekLast()==null) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
		printSpiral(root);
		
	}
}