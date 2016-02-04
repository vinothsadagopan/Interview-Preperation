/*	Chapter 2 Question 2 (Cracking the coding interview 5th edition)
	Implement an algorithm to find the kth to last element of a singly linked list. 
*/

class FindKthtoLastLL {
	public static Node head = null;
	public static void insert(int data) {
		head=insert(head,data);
	}
	public static Node insert (Node head, int data) {
		if(head==null) {
			head = new Node(data);
		}
		else if(head.next==null) {
			head.next = new Node(data);
		}
		else {
			Node temp = head;
			while (temp.next!=null) temp= temp.next;
			temp.next = new Node(data);
		}
		return head;
	}
	public static void kthtoLast(int k) {
		kthtoLast(head,k);
	}
	public static void kthtoLast(Node head,int k) {
		Node p1=head;
		Node p2=head;
		for(int i =0;i <k-1;i++) {
			p2 =p2.next;
		}
		while(p2.next!=null) {
			p1 =p1.next;
			p2=p2.next;
		}
		System.out.println(p1.data);
	}
	public static int kthtoLastRecursive(int k) {
		return kthtoLastRecursive(head, k);
	}
	public static int kthtoLastRecursive(Node head, int k) {
		if(head == null) {
			return 0;
		}
		int i = kthtoLastRecursive(head.next,k) +1;
		if(i==k) System.out.println(head.data);
		return i;
	}
	public static void main(String[] args) {
		int[] input={1,4,2,3,2,8};
		for(int n:input) {
			insert(n);
		}
		kthtoLast(3);
		kthtoLastRecursive(3);
	}
}