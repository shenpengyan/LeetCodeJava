import common.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * @author shenpengyan
 *
 */
public class Code25 {

	public static void main(String[] args) {
		Code25 code = new Code25();
		Solution sol = code.new Solution();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next = new ListNode(6);
		System.out.println(sol.reverseKGroup(l1, 1));
	}

	class Solution {
		public ListNode reverseKGroup(ListNode head, int k) {
			ListNode res = null;
			ListNode resTail = null;
			ListNode reverseHead = head;
			ListNode reverseTail = head;
			int i = 1;

			while (reverseTail != null) {
				if (i < k && reverseTail.next != null) {
					ListNode temp = reverseTail.next.next;
					reverseTail.next.next = reverseHead;
					reverseHead = reverseTail.next;
					reverseTail.next = temp;
					i++;
				} else if (i == k) {
					i = 1;
					if (res == null) {
						res = reverseHead;
						resTail = reverseTail;
					} else {
						resTail.next = reverseHead;
						resTail = reverseTail;
					}
					reverseHead = reverseTail.next;
					reverseTail = reverseHead;
				} else {
					// 个数不够，将反过去的再反回来
					reverseTail = null;
					if (res == null) {
						res = reverseKGroup(reverseHead, i);
					} else {
						resTail.next = reverseKGroup(reverseHead, i);
					}
				}
			}
			return res;
		}
	}
}
