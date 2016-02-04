/* Chgapter 2 Question 7 (Cracking the coding interview)
Given a circular linked list implement an algorithm which returns the begining of the loop*/

class CircularLinkedList {
	
	public static Node getBegining(Node head) {
		Node slowRunner = head;
		Node fastRunner = head;
		while(fastRunner!=null && fastRunner.next!=null) {
			slowRunner = slowRunner.next;
			fastRunner=fastRunner.next.next;
			if(slowRunner == fastRunner) {
				break;
			}
		}
		if(fastRunner==null || fastRunner.next == null) {
			return null;
		}
		slowRunner = head;
		while(slowRunner!=fastRunner) {
			slowRunner= slowRunner.next;
			fastRunner=fastRunner.next;
		}
		return slowRunner;
	}
	public static void main(String[] args) {
		Node input = new Node(1);
		input.next= new Node(2);
		input.next.next= new Node(3);
		input.next.next.next = new Node(4);
		input.next.next.next.next= new Node(5);
		input.next.next.next.next.next = new Node(6);
		input.next.next.next.next.next.next =input.next.next;
		Node result = getBegining(input);
		System.out.println("The begining of the loop is "+result.data);
	}
}