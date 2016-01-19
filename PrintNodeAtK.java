import java.util.Deque;
import java.util.LinkedList;
class PrintNodeAtK {

	static TreeNode root =null;
	public static void insert(int data) {
		root = insert(root, data);
	}
	public static TreeNode insert(TreeNode root, int data) {
		if(root == null) root = new TreeNode(data);
		if(data< root.data) root.left = insert(root.left,data);
		if(data > root.data) root.right = insert(root.right, data);
		return root;
	}
	public static void findInChild(TreeNode root, int k) {
		if(root == null) return;
		if(k==0) System.out.println(root.data);
		findInChild(root.left, k-1);
		findInChild(root.right, k-1);
	}
	public static int printNodes(int dest, int k) {
		return printNodes(root, dest,k);
	}
	public static int printNodes(TreeNode root,int dest, int k) {

		if(root == null) return -1;
		if(root.data == dest) {
			findInChild(root, k);
			return k -1;
		}
		int found = printNodes(root.left, dest,k);
		if(found!= -1) {
			if(found == 0) {
				System.out.println(root.data);
			}
			else {
				findInChild(root.right, found-1);
			}
			return found-1;
		}
		found = printNodes(root.right,dest, k);
		if(found!=-1) {
			if(found == 0) {
				System.out.println(root.data);
			}
			else {
				findInChild(root.left,found-1);
			}
			return found-1;
		}
		return -1;


	}
	public static void main(String[] args) {
		int[] inputArray = {20,8,22,4,12,21,26,10,14,9,16};
		for(int n: inputArray) insert(n);
		System.out.println(" Printing neighbour nodes for 12 at distance 2 :");
		printNodes(12,2);
		System.out.println(" Printing neighbour nodes for 12 at distance 3 :");
		printNodes(12,3);

	}

}