class Node {
	int data; 
	Node next;
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
}
class Sample {
	public static boolean isPalindrome(Node head) {
		Node next=head;
       return isPalindrome(head,next);
	}
	public static boolean isPalindrome(Node head, Node next) {
		if(next==null) return true;
		System.out.print("head "+head.data);
		System.out.print(" next "+next.data);
		System.out.println("Before Recursion-----");
        boolean value = isPalindrome(head, next.next) &&head.data==next.data;
        System.out.print("head "+head.data);
		System.out.print(" next "+next.data);
		System.out.println("After Recursion-----");
        
        head=head.next;
        return value;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next= new Node(2);
		head.next.next.next = new Node(1);
		System.out.println("is the given list is a palindrome ?"+isPalindrome(head));
	}
}