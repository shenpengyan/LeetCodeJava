/**
 * 38. Count and Say 
 * The count-and-say sequence is the sequence of integers
 * beginning as follows: 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read
 * off as "one 2, then one 1" or 1211. Given an integer n, generate the nth
 * sequence.
 * 
 * link: https://leetcode.com/problems/count-and-say/
 * 
 * @author shenpengyan
 *
 */
public class Code38CountAndSay {

	public static void main(String[] args) {
		Code38CountAndSay code = new Code38CountAndSay();
		Solution sol = code.new Solution();
		System.out.println(sol.countAndSay(5));
	}

	class Solution {
		public String countAndSay(int n) {
			if(n == 1){
				return "1";
			}
			String rst = "";
			String str = countAndSay(n - 1);
			char tempChar = 0;
			int tempNum = 0;
			char[] strChars = str.toCharArray();
			for (char c : strChars) {
				if(c == tempChar){
					tempNum ++;
				}
				else
				{
					if(tempChar != 0){
						rst += ("" + tempNum + "" + tempChar);
					}
					tempChar = c;
					tempNum = 1;
				}
			}
			if(tempChar != 0){
				rst += ("" + tempNum + "" + tempChar);
			}
			return rst;
		}
	}
}

//分析：题意非常难理解，
//     题意是n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，
//     所以输出11；n=3时，由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，有1个2和1个1，
//     所以输出1211。依次类推，写个countAndSay(n)函数返回字符串。
// 理解了题意之后用递归就可以很容易出结果了。

