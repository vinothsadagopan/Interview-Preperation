/*
	Chapter 2 Question 7 (Cracking the coding interview 5th edition)
	Implement an algorithm to check if a given linked list is a palindrome
*/

class CheckPalindromeLL {
	public static Node head;
	
	public static boolean checkPalindrome() {
		if(head==null ||head.next ==null) return true;
		else {
			
			return checkPalindrome(head);
		}

	}
	public static boolean checkPalindrome(Node current) {
		if(current == null) {
			return true;
		}
		else {
			boolean value = checkPalindrome(current.next)&&temp.data == current.data;
			head=head.next;
			return value;
		}
		
	}

	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next= new Node(2);
		head.next.next.next =new Node(1);
		System.out.println("is the given linked list is a palindrome ? "+checkPalindrome()); 
	}
}