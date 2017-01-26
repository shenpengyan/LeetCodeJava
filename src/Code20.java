import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Code20 {
	public static void main(String[] args){
		Code20 code = new Code20();
		Solution sol = code.new Solution();
		System.out.println(sol.isValid("[12312]{asfds}"));
	}
	
	
	class Solution{
	    public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<Character>();
	        char[] cs = s.toCharArray();
	        Set<Character> s1 = new HashSet<Character>(Arrays.asList(new Character[]{'{','[','('}));
	        Set<Character> s2 = new HashSet<Character>(Arrays.asList(new Character[]{'}',']',')'}));
	        for (char c : cs) {
				if(s1.contains(c)){
					stack.push(c);
				}
				if(s2.contains(c)){
					switch (c) {
					case '}':
						if(!stack.isEmpty() && stack.peek() == '{'){
							stack.pop();
						}
						else{
							return false;
						}
						break;
					case ']':
						if(!stack.isEmpty() && stack.peek() == '['){
							stack.pop();
						}
						else{
							return false;
						}
						break;
					case ')':
						if(!stack.isEmpty() && stack.peek() == '('){
							stack.pop();
						}
						else{
							return false;
						}
						break;
					}
				}
			}
	        if(stack.isEmpty()){
	        	return true;
	        }
	        else
	        {
	        	return false;
	        }
	    }
	}
}
