/*
 To print level order traversal in spiral way using recursive solution.
*/



class SpiralOrderRecursive {
	public static TreeNode root = null;
	public static void printLevel() {
		int height = height(root);
		boolean ltr = false;
		for (int i=1;i<=height ;i++ ) {
			printLevelOrder(root,i,ltr);
			ltr= !ltr;
		}
	}
	public static void printLevelOrder(TreeNode root, int level, boolean ltr) {
		if(root == null) {
			return;
		}
		if(level ==1) {
			System.out.print(root.data +" ");
		}
		else if(level > 1) {
			if(ltr) {
				printLevelOrder(root.left, level-1,ltr);
				printLevelOrder(root.right, level-1,ltr);
			}
			else {
				printLevelOrder(root.right, level -1, ltr);
				printLevelOrder(root.left, level-1,ltr);
			}
		}
	}

	public static int height(TreeNode root) {
		if(root ==null) return 0;
		else {
			return 1 +Math.max(height(root.left), height(root.right));
		}
	}

	public static void main(String[] args) {
		root = new TreeNode(1);
		root.left= new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left= new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		printLevel();

	}
}