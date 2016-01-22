/*
	 To get the mirror image of given binary tree.
*/

class MirrorTree {
	public static TreeNode root = null;
	
	public static void mirror(TreeNode root) {
		if(root == null) return;
		else {
			mirror(root.left);
			mirror(root.right);
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
	
	public static void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		else {
			inOrder(root.left);

			System.out.print(root.data+" ");
			inOrder(root.right);	
		}
		
	}

	public static void main(String[] args) {
		root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(5);
		mirror(root);
		inOrder(root);
		
	}
}
