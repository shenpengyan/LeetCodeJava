import java.util.ArrayList;
import java.util.List;

public class Code131Partition {
	
	public static void main(String[] args){
		Code131Partition code = new Code131Partition();
		Solution sol = code.new Solution();
		System.out.println(sol.partition("abb"));
	}
	
	
	class Solution{
	    public List<List<String>> partition(String s) {
	    	List<List<String>> list = new ArrayList<>();
	    	backtrack(list, new ArrayList<String>(), s);
	        return list;
	    }
	    
	    public void backtrack(List<List<String>> list, List<String> tempList, String s){
	    	if(s.length() == 0){
	    		list.add(new ArrayList<>(tempList));
	    	}
	    	for (int i = 1; i <= s.length(); i++) {
				String leftS = s.substring(0, i);
				if(isPalindrome(leftS)){
					tempList.add(leftS);
					backtrack(list, tempList, s.substring(i, s.length()));
					tempList.remove(tempList.size() - 1);
				}
			}
	    }
	    
	    public boolean isPalindrome(String s){
	    	char[] cs = s.toCharArray();
	    	int left = 0, right = s.length() - 1;
	    	while(left < right){
	    		if(cs[left] != cs[right])
	    			return false;
	    		else{
	    			left++;
	    			right--;
	    		}
	    	}
	    	return true;
	    }
	}
}
