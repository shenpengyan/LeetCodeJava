package common;
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
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