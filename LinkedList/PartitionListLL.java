/*	Chapter 2 Question 4 (Cracking the coding interview 5ht edition)
	Write code to partition a linked list around a value X, such that all nodes less than 
	x,comes befpre all nodes greater than or equal to x.
*/
class PartitionListLL {
	public static Node head = null;
	public static void addFirst(int data) {
		addFirst(head, data);
	}
	public static void addFirst(Node head, int data) {
		if(head==null) head= new Node(data);
		else {
			Node temp = new Node(data);
			temp.next = head;
		}
	}
	public static void addLast(int data) {
		addLast(head, data);
	}
	public static void addLast(Node head, int data) {
		if(head==null) head= new Node(data);
		else {
			Node temp = head;
			while(temp.next!=null) {
				temp= temp.next;
			}
			temp.next = new Node(data);
		}
	}
	public static void partitionList(int[] input, int data) {
		head =partitionList(head,input,data);
	}
	public static Node partitionList(Node head, int[]input, int data) {
		head = new Node(data);
		for(int n:input) {
			if(n< head.data) addFirst(n);
			else if(n>= head.data) addLast(n);
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
		int[] input ={1,3,4,5,9,11,13,15};
		partitionList(input, 8);
		print();
	}
}