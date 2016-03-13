/*
 To print level order traversal using two stacks
*/
import java.util.Stack;
import java.util.LinkedList;
class SpiralOrderIterative1 {
	public static TreeNode root = null;
	public static void printSpiral(TreeNode root) {
		Stack <TreeNode> stack1 = new Stack<TreeNode>();
		Stack <TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				TreeNode temp = stack1.pop();
				if(temp.left!= null) stack2.push(temp.left);
				if(temp.right!=null) stack2.push(temp.right);
				System.out.print(temp.data +" ");
			}
			while(!stack2.isEmpty()) {
				TreeNode temp = stack2.pop();
				if(temp.right!=null) stack1.push(temp.right);
				if(temp.left!= null) stack1.push(temp.left);
				System.out.print(temp.data+" ");
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