/* You have two numbers represented by a linked list , where each node contains a single digit. The digits are stored in reverse order
	THe digits are stored in reverse order.
	617 +295
	7->1->6
	+
	5->9->2
	2->1->9(912)

*/

class LLAddition1 {
	//public static Node head =null;
	public static Node addLists(Node l1, Node l2, int carry) {
		if(l1==null && l2==null && carry==0) return null;
		int value = carry;
		if(l1!=null)
			value+=l1.data;
		if(l2!=null)
			value+=l2.data;
		System.out.println(value);
		int x = value % 10;
		Node result = new Node(x);
		if(l1!=null || l2!=null) {
			result.next = addLists(l1==null?null:l1.next, l2==null?null:l2.next, value>=10? 1:0);
		}
		return result;
	}
	public static void print(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head= head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node l1 = new Node(4);
		l1.next = new Node(3);
		l1.next.next = new Node(2);
		l1.next.next.next = new Node(1);
		Node l2 = new Node(7);
		l2.next = new Node(6);
		l2.next.next = new Node(5);
		Node result = addLists(l1,l2,0);
		//print(l1);
		//print(l2);
		print(result);

	}

}