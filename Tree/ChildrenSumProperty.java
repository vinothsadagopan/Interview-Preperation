/*
Program to check if root is equal to sum of its left and right children nodes in BT*/
class ChildrenSumProperty {
	public static TreeNode root = null;
	public static int checkSumProperty(TreeNode root) {
		if(root ==null) return 0;
		int sum = checkSumProperty(root.left) + checkSumProperty(root.right);
		if(sum == root.data || sum == 0)
			return root.data;
		else 
			return -1;
	}
	
	public static void main(String[] args) {

		root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(3);
		if(root.data == checkSumProperty(root)) System.out.println("Children Sum Property is satisfied");
		else
			System.out.println("Not satisfied");


	}	
}