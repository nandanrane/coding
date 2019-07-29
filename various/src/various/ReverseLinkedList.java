package various;

public class ReverseLinkedList {
	
	public static ListNode reverseLinkedListRecur(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode reverseListHead = reverseLinkedListRecur(head.next);
		
		head.next.next = head;
		
		head.next = null;
		
		return reverseListHead;
	}
	
	public static ListNode reverseLinkedList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
		
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		head.next = n1;
		
		
		ListNode n2 = new ListNode(3);
		n1.next = n2;
		
		ListNode n3 = new ListNode(4);
		n2.next = n3;
		
		//ListNode newHead = reverseLinkedListRecur(head);
		ListNode newHead = reverseLinkedListRecur(head);
		
		while(newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}