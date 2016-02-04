class ReverseLinkedListRecursive {
	public static Node head;
	public static void reverse(Node current) {
		if(current == null) return;
		if( current.next ==null) {
			head=current;
			return;
		}
		reverse(current.next);
		Node q = current.next;
		q.next= current;
		current.next =null;
	}
	public static void print(Node head) {
		if(head==null) System.out.println("List is empty");
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
		head = new Node(1);
		head.next = new Node(2);
		head.next.next= new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		print(head); 
		reverse(head);
		print(head);
	}
}