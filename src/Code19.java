import common.ListNode;

/**
 * 
 * 19. Remove Nth Node From End of List
 * 
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * Note: Given n will always be valid. Try to do this in one pass.
 * 
 * link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author shenpengyan
 *
 */
public class Code19 {
	public static void main(String[] args) {
		Code19 code = new Code19();
		Solution sol = code.new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(sol.removeNthFromEnd(head, 2));
	}

	/**
	 * what is one pass???
	 * @author shenpengyan
	 *
	 */
	class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			int length = 1;
			ListNode temp = head;
			while(temp.next != null){
				temp = temp.next;
				length ++;
			}
			if(length == n-1) return head.next;
			temp = head;
			for (int i = 0; i < length - n - 1 ; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			return head;
		}

	}

}
