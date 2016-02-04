class DeleteMiddleNodeLL {
	public static Node head =null;
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
	public static void deletemiddle(int data) {
		Node temp = findNode(data);
		deletemiddle(head, temp);
	}
	public static void deletemiddle(Node head, Node tobedel) {
		if (head == null) {
			System.out.println("List is empty cant be deleted");
		}
		Node temp = head;
		while(temp.next.data!=tobedel.data) {
			temp = temp.next;
		}
		temp.next=temp.next.next;
	}
	public static Node findNode(int data) {
		Node temp = findNode(head,data);
		return temp;
	}
	public static Node findNode(Node head, int data) {
		if(head == null) return null;
		Node temp = head;
		while(temp.next!=null) {
			if(temp.data == data) {
				break;
			}
			temp =temp.next;
		}
		return temp;
	}
	public static void print() {
		if(head== null) System.out.println("List is empty");
		else {
			Node temp = head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] input={1,4,2,3,2,8};
		for(int n:input) {
			insert(n);
		}
		print();
		deletemiddle(2);
		print();
	}
}