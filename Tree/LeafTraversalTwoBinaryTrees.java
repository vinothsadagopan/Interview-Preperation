/*
Check if leaf traversal of two Binary Trees is same?
Question Source: Geeks For Geeks
*/
import java.util.Deque;
import java.util.LinkedList;
class LeafTraversalTwoBinaryTrees {
	public static boolean isLeafNode(TreeNode root) {
		if(root.left == null && root.right==null) return true;
		else return false;
	}
	public static boolean isLeafTraversalSame(TreeNode root1, TreeNode root2) {
		Deque<TreeNode> stack1 = new LinkedList<TreeNode>();
		Deque<TreeNode> stack2 = new LinkedList<TreeNode>();
		stack1.addFirst(root1);
		stack2.addFirst(root2);
		while(!stack1.isEmpty() ||!stack2.isEmpty() ) {
			TreeNode temp1 = stack1.removeFirst();
			while(temp1!=null && !isLeafNode(temp1)) {
				if(temp1.right!=null) stack1.addFirst(temp1.right);
				if(temp1.left !=null) stack1.addFirst(temp1.left);
				temp1= stack1.pop();
			}
			TreeNode temp2 = stack2.removeFirst();
			while(temp2!=null && !isLeafNode(temp2)) {
				if(temp2.right!=null) stack2.addFirst(temp2.right);
				if(temp2.left!=null) stack2.addFirst(temp2.left);
				temp2 =stack2.pop();
			}
			if(temp1==null &&temp2!=null) {
				return false;
			}
			if(temp1!=null && temp2!= null) {
				if(temp1.data !=temp2.data) return false;
			}

		}
		return true;
	}
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		TreeNode root2 =new TreeNode(0);
		root2.left = new TreeNode(5);
		root2.right = new TreeNode(8);
		root2.left.right = new TreeNode(4);
		root2.right.left = new TreeNode(6);
		root2.right.right = new TreeNode(7);
		System.out.println(isLeafTraversalSame(root1,root2));
	}
}