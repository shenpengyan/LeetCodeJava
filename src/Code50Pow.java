/**
 * 
 * 50. Pow(x, n)
 * 
 * Implement pow(x, n).
 * 
 * link: https://leetcode.com/problems/powx-n/
 * 
 * @author shenpengyan
 *
 */
public class Code50Pow {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n == -1)
			return 1 / x;
		int div = n / 2;
		double temp = myPow(x, div);
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			if (n > 0)
				return temp * temp * x;
			else {
				return temp * temp / x;
			}
		}
	}
}

// 分析：自己实现乘方运算，注意，递归对内存空间占用比较大。