class ReverseLinkedListIterative {
	public static Node reverse(Node head) {
		if(head==null) return null;
		if(head.next == null) return head;
		else {
			Node prev=null,currrent= null, next = head;
			while(next!= null) {
				//System.out.println(next.data);
				currrent =next;
				next=next.next;
				currrent.next=prev;
				prev=currrent;
				
			}
			
			return currrent;
		}

	}
	public static void print(Node head) {
		if(head == null) System.out.println("List is empty");
		if(head.next == null) System.out.println(head.data);
		else {
			Node temp = head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp= temp.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		print(head);
		Node reversed = reverse(head);
		print(reversed);
	}
}