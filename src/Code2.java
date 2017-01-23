
/**
 * 2. Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * link: https://leetcode.com/problems/add-two-numbers/
 * 
 * @author shenpengyan
 *
 */
public class Code2 {
	public static void main(String[] args) {
		Code2 code = new Code2();
		Solution sol = code.new Solution();
		ListNode l1 = code.new ListNode(2);
		l1.next = code.new ListNode(4);
		l1.next.next = code.new ListNode(3);
		ListNode l2 = code.new ListNode(5);
		l2.next = code.new ListNode(6);
		l2.next.next = code.new ListNode(4);
		System.out.println(sol.addTwoNumbers(l1, l2));
	}

	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	ListNode head = new ListNode(0);
	    	ListNode tail = head;
	    	boolean over9 = false;
	    	while(true){
	    		if(l1 == null && l2 == null){
	    			if(over9){
	    		    	ListNode nextNode = new ListNode(1);
	    		    	tail.next = nextNode;
	    		    	over9 = false;
	    		    	break;
	    			}
	    			else{
		    			break;
	    			}
	    		}
		    	if(l1 == null){
		    		if(over9){
		    			l1 = new ListNode(1); 
		    			over9 = false;
		    		}
		    		else{
			    		tail.next = l2;
			    		break;
		    		}
		    	}
		    	if(l2 == null){
		    		if(over9){
		    			l2 = new ListNode(1); 
		    			over9 = false;
		    		}
		    		else{
			    		tail.next = l1;
			    		break;
		    		}
		    	}
		    	int sum = l1.val + l2.val + (over9 ? 1: 0);
		    	if(sum >= 10){
		    		over9 = true;
		    	}
		    	else
		    	{
		    		over9 = false;
		    	}
		    	ListNode nextNode = new ListNode(sum % 10);
		    	tail.next = nextNode;
		    	tail = tail.next;
		    	l1 = l1.next;
		    	l2 = l2.next;
	    	}
	    	return head.next;
	    	
	    }
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
		
	    public String toString(){
	    	if(next == null){
		    	return val + "";
	    	}
	    	else
	    	{
	    		return val + "->" + next.toString();
	    	}
	    }
	}

}
