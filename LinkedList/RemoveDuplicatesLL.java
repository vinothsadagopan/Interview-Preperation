/*
	Chapter 2 Question 1 (Cracking the coding interview 5th edition)
	Write code to remove duplicates from an unsoreted linked list.
	FOLLOW UP
	How would you solve this problem if a temporary buffer is not allowed?
*/
import java.util.Set;
import java.util.HashSet;
class RemoveDuplicatesLL {
	public static Node head=null;
	public static void insert(int data) {
		head=insert(head,data);
	}
	public static void removeDuplicates() {
		removeDuplicates(head);
	}
	public static void removeDuplicatesWB() {
		removeDuplicatesWB(head);
	}
	public static void removeDuplicatesWB(Node head) {
		if(head == null) System.out.println("List is empty.... cannot remove duplicates");
		Node current = head;
		while(current!=null) {
			Node runner = current;
			while(runner.next!=null) {
				if(runner.next.data==current.data) {
					runner.next = runner.next.next;
				}
				else {
					runner=runner.next;
				}
			}
			current=current.next;
		}
	}
	public static void removeDuplicates(Node head) {
		Set<Integer> set= new HashSet<Integer>();
		Node temp = head;
		Node previous = null;
		while(temp!=null) {
			if(!set.contains(temp.data)) {
				set.add(temp.data);
				previous=temp;
			}
			else {
				previous.next =temp.next;
			}
			temp=temp.next;
		}
	}
	public static void delete(int data) {
		 delete(head, data);
	}
	public static void delete(Node head, int data) {
		if(head==null|| head.next==null) return;
		else {
			Node temp =head;
			while(temp.next!=null) {
				if(temp.next.data == data) {
					temp.next = temp.next.next;
				}
				temp=temp.next;
			}
			
		}

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
		int[] input ={1,4,2,4,3};
		for (int n :input ) {
			insert(n);
		}
		print();
		removeDuplicatesWB();
		print();
	}
}