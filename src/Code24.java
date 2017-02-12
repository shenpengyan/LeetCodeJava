import common.ListNode;

/**
 * 
 * 24. Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * link: https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author shenpengyan
 *
 */
public class Code24 {

	public static void main(String[] args) {
		Code24 code = new Code24();
		Solution sol = code.new Solution();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		System.out.println(sol.swapPairs(l1));
	}

	class Solution {
		public ListNode swapPairs(ListNode head) {
			if (head == null || head.next == null)
				return head;
			ListNode res = head.next;
			head.next = head.next.next;
			res.next = head;
			ListNode tail = head.next;
			ListNode tailParent = head;
			while (tail != null && tail.next != null) {
				tailParent.next = tail.next;
				tail.next = tail.next.next;
				tailParent.next.next = tail;
				tailParent = tailParent.next.next;
				tail = tailParent.next;
			}
			return res;
		}
	}
}
