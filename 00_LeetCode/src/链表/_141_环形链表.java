package 链表;

public class _141_环形链表 {
	
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false; 
		
		/** 快慢指针 (一个走的块,一个走的慢)*/
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (fast != null && fast.next != null) {
			if(slow == fast) return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
    }
}
