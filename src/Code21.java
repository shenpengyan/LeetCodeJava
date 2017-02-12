import common.ListNode;

/**
 * 
 * 21. Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists. 
 * 
 * link: https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * @author shenpengyan
 *
 */
public class Code21 {

	public static void main(String[] args) {
		Code21 code = new Code21();
		Solution sol = code.new Solution();
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode res = sol.mergeTwoLists(l1, l2);
		System.out.println(res);
	}

	class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			if (l1.val < l2.val) {
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			} else {
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
		}
	}

	class BadSolution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null) {
				return l2;
			} else if (l2 == null) {
				return l1;
			}
			ListNode head = null;
			if (l1.val < l2.val) {
				head = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				head = new ListNode(l2.val);
				l2 = l2.next;
			}
			ListNode tail = head;
			while (l1 != null || l2 != null) {
				if (l1 != null && l2 != null) {
					if (l1.val < l2.val) {
						tail.next = new ListNode(l1.val);
						l1 = l1.next;
						tail = tail.next;
					} else {
						tail.next = new ListNode(l2.val);
						l2 = l2.next;
						tail = tail.next;
					}
				} else if (l1 == null) {
					tail.next = l2;
					l2 = null;
				} else {
					tail.next = l1;
					l1 = null;
				}
			}
			return head;
		}
	}



}
