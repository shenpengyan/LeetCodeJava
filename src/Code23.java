import java.util.Comparator;
import java.util.PriorityQueue;

import common.ListNode;

/**
 * 
 * @author shenpengyan
 *
 */
public class Code23 {
	public static void main(String[] args){
		Code23 code = new Code23();
		Solution sol = code.new Solution();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(6);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(5);
		System.out.println(sol.mergeKLists(new ListNode[]{l1,l2}));
	}
	
	/**
	 * 使用优先队列
	 * @author shenpengyan
	 *
	 */
	class Solution2{
	    public ListNode mergeKLists(ListNode[] lists) {
	    	if(lists == null || lists.length == 0) return null;
	    	
	    	PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
				@Override
				public int compare(ListNode o1, ListNode o2) {
					if(o1.val < o2.val)
						return -1;
					else if(o1.val == o2.val)
						return 0;
					else
						return 1;
				}
			});
	    	
	    	ListNode dummy = new ListNode(0);
	    	ListNode tail = dummy;
	    	
	    	for (ListNode node : lists) {
				if(node != null){
					queue.add(node);
				}
			}
	    	
	    	while (!queue.isEmpty()) {
				tail.next = queue.poll();
				tail = tail.next;
				
				if(tail.next != null)
					queue.add(tail.next);
			}
	    	return dummy.next;
	    }
	}
	
	class Solution{
	    public ListNode mergeKLists(ListNode[] lists) {
	    	return mergeKLists(lists, 0, lists.length -1);
	    }
	    
	    public ListNode mergeKLists(ListNode[] lists, int start, int end){
	    	if(start == end){
	    		return lists[start];
	    	}
	    	else if(start < end){
	    		int mid = (start + end) / 2;
	    		ListNode left = mergeKLists(lists, start, mid);
	    		ListNode right = mergeKLists(lists, mid + 1, end);
	    		return mergeTwoLists(left, right);
	    	}
	    	else{
	    		return null;
	    	}
	    }
	    
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
/**
 * 整体比较太慢,两种方法：一种使用二分法，
 */
//	class Solution{
//	    public ListNode mergeKLists(ListNode[] lists) {
//	        ListNode min = getMinListNode(lists);
//	        if(min == null){
//	        	return null;
//	        }
//	        else{
//	        	for (int i = 0; i < lists.length; i++) {
//					if(min.equals(lists[i])){
//						lists[i] = min.next;
//					}
//				}
//	        	min.next = mergeKLists(lists);
//	        	return min;
//	        }
//	    }
//	    
//	    public ListNode getMinListNode(ListNode[] lists){
//	    	if(lists.length == 0){
//	    		return null;
//	    	}
//	    	ListNode min = lists[0];
//	    	
//	    	for (ListNode listNode : lists) {
//	    		if(min == null){
//	    			min = listNode;
//	    		}
//				if(listNode != null && listNode.val < min.val){
//					min = listNode;
//				}
//			}
//	    	return min;
//	    }
//	}
}
