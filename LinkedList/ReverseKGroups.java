class ReverseKGroups {
	public static Node reverseK(Node head, int k) {
		Node current =head;
		Node prev=null, next=null;
		int count=0;
		while(current!=null && count<k) {
			next =current.next;
			current.next =prev;
			prev=current;
			current=next;
			count++;
		}
		if(head!=null) {
			head.next = reverseK(current,k);
		}
		return prev;
	}
	public static void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;

		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node input = new Node(1);
		input.next= new Node(2);
		input.next.next= new Node(3);
		input.next.next.next = new Node(4);
		input.next.next.next.next= new Node(5);
		input.next.next.next.next.next = new Node(6);
		input.next.next.next.next.next.next=new Node(7);
		printList(input);
		Node reverse = reverseK(input,2);
		printList(reverse);
	}
}