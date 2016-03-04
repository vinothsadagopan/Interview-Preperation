import java.util.*;
class ReverseAlternateAppend {
	public static Node reverseAlternate(Node head) {
		if(head==null) return null;
		if(head.next==null) return head;
		Deque<Node> st = new LinkedList<Node>();

		Node temp= head;
		Node last=null;
		while(temp!=null) {
			if(temp.next!=null) {
				
				st.addFirst(new Node(temp.next.data));
			}
			temp.next=temp.next.next;
			last=temp;
			temp=temp.next;
		} 
		while(!st.isEmpty()) {
			last.next = st.removeFirst();
			last=last.next;
		}
		return head;
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
		//input.next.next.next.next.next.next=new Node(7);
		printList(input);
		Node reverse = reverseAlternate(input);
		printList(input);
		
	}
}