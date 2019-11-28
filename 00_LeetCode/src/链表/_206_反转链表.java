package 链表;
/**
 *  https://leetcode-cn.com/problems/reverse-linked-list/ 
 */
public class _206_反转链表 {
	/** 递归方法  执行速度不行*/
//	public ListNode reverseList(ListNode head) {
////		if(head == null) return null;
////		if(head.next == null) return head;
//		if(head == null || head.next == null) return head;
//		
//		ListNode newHead = reverseList(head.next);
//		head.next.next = head;
//		head.next = null;
//        return newHead;
//    }
	
	/** 迭代方法 */
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode newHead = null;
		while( head != null) {
			ListNode tempNode = head.next;
			head.next = newHead;
			newHead = head;
			head = tempNode;
		}
        return newHead;
    }
}
