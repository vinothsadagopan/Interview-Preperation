class ReverseLinkedListAlternate {
	public static Node reverseAlternateK(Node head, int k) {
		Node cur=head;
		Node prev=null,next=null;
		int count =0;
		while(cur!=null && count<k) {
			next = cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
			count++;
		}
		if(head!=null) {
			head.next =cur;
		}
		count =0;
		while(count<k-1 && cur!=null) {
			cur=cur.next;
			count++;
		}
		if(cur!=null) {
			cur.next =reverseAlternateK(cur.next, k);
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
		Node reverse = reverseAlternateK(input,2);
		printList(reverse);
	}
}