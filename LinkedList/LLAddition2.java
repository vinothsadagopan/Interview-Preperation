
class PartialSum {
	public Node sum = null;
	public int carry =0;
}
class LLAddition2 {
	public static int Length(Node head) {
		if(head==null) return 0;
		else return Length(head.next)+1;
	}
	public static Node padList(Node head, int padding) {
		for(int i=0;i<padding;i++) {
			Node temp = new Node(0);
			temp.next = head;
			head= temp;
		}
		return head;
	}
	public static Node addLists(Node l1, Node l2 ) {
		int length1 = Length(l1);
		int length2=Length(l2);
		Node result;
		if(length1 < length2) {
			l1 = padList(l1, length2-length1);
		}
		else if(length2< length1) {
			l2 = padList(l2, length1-length2);
		}
		PartialSum sum = addListHelper(l1,l2);
		if(sum.carry == 0) {
			return sum.sum;
		} else {
			result = new Node()
		}
		
		
	}
	public static PartialSum addListHelper(Node l1, Node l2) {
		if(l1==null && l2 ==null) {
			PartialSum sum  = new PartialSum();
			return sum;
		}
		PartialSum sum = addListHelper(l1.next,l2.next);
		int val = sum.carry+ l1.data+l2.data;
		Node result = new Node(val%10);
		result.next = sum.sum;
		sum.sum = result;
		sum.carry = val/10;
		print(sum.sum);
		return sum;

	}
	public static void print(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head= head.next;
		}
		System.out.println();
	}
	public static Node insertBefore(Node list, int data) {
        Node node = new Node(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

	public static void main(String[] args) {
		Node l1= new Node(9);
		l1.next = new Node(2);
		l1.next.next = new Node(3);
		l1.next.next.next = new Node(4);
		Node l2 = new Node(7);
		l2.next = new Node(6);
		l2.next.next = new Node(7);
		Node result = addLists(l1,l2);
		print(result);

	}
}